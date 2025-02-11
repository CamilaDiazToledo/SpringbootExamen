package com.campus.restaurante.domain.service;

import com.campus.restaurante.domain.repository.UserRepository;
import com.campus.restaurante.dto.CreateUserDto;
import com.campus.restaurante.dto.UserDto;
import com.campus.restaurante.persistence.entity.Users;
import com.campus.restaurante.web.exceptions.DataInUseException;
import com.campus.restaurante.web.exceptions.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl  implements UserService {

    private final UserRepository userRepositorty;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepositorty, PasswordEncoder passwordEncoder) {

        this.userRepositorty = userRepositorty;
        this.passwordEncoder = passwordEncoder;

    }

//CREATE......................................................................


    @Transactional
    @Override
    public ResponseEntity<UserDto> createUser(CreateUserDto createUserDTO) {
        //validacion email
        ResponseEntity<UserDto> userResponse = findByEmailToCreate(createUserDTO.getEmail());
        if (userResponse.getStatusCode().is2xxSuccessful()) {
            throw new DataInUseException(createUserDTO.getEmail() + " Email can not be used");
        }

        //validacion userName
        ResponseEntity<UserDto> userResponse2 = findByNameToCreate(createUserDTO.getName());
        if (userResponse2.getStatusCode().is2xxSuccessful()) {
            throw new DataInUseException(createUserDTO.getName() + " User name can not be used");
        }

        Users usercreated = Users.fromDTOCreate(createUserDTO);
        usercreated = userRepositorty.save(usercreated);
        return ResponseEntity.ok(usercreated.toDTO());
    }

    //FIND.........................................................................
    @Transactional
    @Override
    public ResponseEntity<UserDto> findByEmail(String email) {
        Optional<Users> usersOpt = userRepositorty.findByEmail(email);
        if (usersOpt.isEmpty()) {
            throw new NotFoundException("No user found with this email: " + email);
        }
        return usersOpt.map(users -> ResponseEntity.ok(users.toDTO()))
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @Override
    public ResponseEntity<UserDto> findByEmailToCreate(String email) {
        Optional<Users> usersOpt = userRepositorty.findByEmail(email);
        if (usersOpt.isPresent()) {
            throw new NotFoundException("User found with this email: " + email);
        }
        return usersOpt.map(users -> ResponseEntity.ok(users.toDTO()))
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @Override
    public ResponseEntity<UserDto> findByNameToCreate(String userName) {
        Optional<Users> usersOpt = userRepositorty.findByName(userName);
        if (usersOpt.isPresent()) {
            throw new NotFoundException("User found with this user name: " + userName);
        }
        return usersOpt.map(users -> ResponseEntity.ok(users.toDTO()))
                .orElse(ResponseEntity.notFound().build());
    }

    //GET.........................................................................
    // todos
    @Transactional
    @Override
    public List<UserDto> getAllUsers() {

        List<Users> users = userRepositorty.findAll();
        if (users.isEmpty()) {
            throw new NotFoundException("No users found");
        }
        return users.stream()
                .map(Users::toDTO)
                .collect(Collectors.toList());
    }

    //por ID
    @Transactional
    @Override
    public ResponseEntity<UserDto>getUserByEmail(String email) {

        Optional<Users> usersOpt = userRepositorty.findByEmail(email);
        if (usersOpt.isEmpty()) {
            throw new NotFoundException("No user found with this Id" + email);
        }
        return usersOpt.map(users -> ResponseEntity.ok(users.toDTO()))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    @Transactional
    public void changePassword(String email, String currentPassword, String newPassword) {
        Optional<Users> user = userRepositorty.findByEmail(email);
        if (!passwordEncoder.matches(currentPassword, user.get().getPassword())) {
            throw new RuntimeException("Current password is incorrect");
        }
        user.get().setPassword(passwordEncoder.encode(newPassword));
        userRepositorty.save(user.get());
    }

}
