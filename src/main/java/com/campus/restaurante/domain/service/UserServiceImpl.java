package com.campus.restaurante.domain.service;

import com.campus.restaurante.domain.repository.UserRepository;
import com.campus.restaurante.dto.CreateUserDto;
import com.campus.restaurante.dto.UserDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

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
        ResponseEntity<UserDto> userResponse2 = findByUserNameToCreate(createUserDTO.getUserName());
        if (userResponse2.getStatusCode().is2xxSuccessful()) {
            throw new DataInUseException(createUserDTO.getUserName() + " User name can not be used");
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
}
