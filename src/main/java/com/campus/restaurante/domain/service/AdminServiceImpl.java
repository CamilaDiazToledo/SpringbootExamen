package com.campus.restaurante.domain.service;

import com.campus.restaurante.domain.repository.AdminRepository;
import com.campus.restaurante.dto.CreateUserDto;
import com.campus.restaurante.dto.UserDto;
import com.campus.restaurante.persistence.entity.Admin;
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
public class AdminServiceImpl implements AdminService{

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {

        this.adminRepository = adminRepository;
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

        Admin usercreated = Admin.fromDTOCreate(createUserDTO);
        usercreated = adminRepository.save(usercreated);
        return ResponseEntity.ok(usercreated.toDTO());
    }

    //FIND.........................................................................
    @Transactional
    @Override
    public ResponseEntity<UserDto> findByEmail(String email) {
        Optional<Admin> usersOpt = adminRepository.findByEmail(email);
        if (usersOpt.isEmpty()) {
            throw new NotFoundException("No user found with this email: " + email);
        }
        return usersOpt.map(users -> ResponseEntity.ok(users.toDTO()))
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @Override
    public ResponseEntity<UserDto> findByEmailToCreate(String email) {
        Optional<Admin> usersOpt = adminRepository.findByEmail(email);
        if (usersOpt.isPresent()) {
            throw new NotFoundException("User found with this email: " + email);
        }
        return usersOpt.map(users -> ResponseEntity.ok(users.toDTO()))
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @Override
    public ResponseEntity<UserDto> findByNameToCreate(String userName) {
        Optional<Admin> usersOpt = adminRepository.findByName(userName);
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

        List<Admin> users = adminRepository.findAll();
        if (users.isEmpty()) {
            throw new NotFoundException("No users found");
        }
        return users.stream()
                .map(Admin::toDTO)
                .collect(Collectors.toList());
    }

    //por ID
    @Transactional
    @Override
    public ResponseEntity<UserDto>getUserByEmail(String email) {

        Optional<Admin> usersOpt = adminRepository.findByEmail(email);
        if (usersOpt.isEmpty()) {
            throw new NotFoundException("No user found with this Id" + email);
        }
        return usersOpt.map(users -> ResponseEntity.ok(users.toDTO()))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    @Transactional
    public void changePassword(String email, String currentPassword, String newPassword) {
        Optional<Admin> user = adminRepository.findByEmail(email);
        if (!passwordEncoder.matches(currentPassword, user.get().getPassword())) {
            throw new RuntimeException("Current password is incorrect");
        }
        user.get().setPassword(passwordEncoder.encode(newPassword));
        adminRepository.save(user.get());
    }
    
}
