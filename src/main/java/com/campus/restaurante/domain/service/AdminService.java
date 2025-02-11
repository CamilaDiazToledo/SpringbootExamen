package com.campus.restaurante.domain.service;

import com.campus.restaurante.dto.CreateUserDTO;
import com.campus.restaurante.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminService {

    ResponseEntity<UserDto> findByEmailToCreate(String email);
    ResponseEntity<UserDto>createUser(CreateUserDTO createUserDto);

    ResponseEntity<UserDto>findByEmail(String email);

    ResponseEntity<UserDto>findByNameToCreate(String name);

    List<UserDto> getAllUsers();
    ResponseEntity<UserDto>getUserByEmail(String email);

    void changePassword(String email, String currentPassword, String newPassword);
    
}
