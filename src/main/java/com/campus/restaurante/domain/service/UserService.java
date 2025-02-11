package com.campus.restaurante.domain.service;

import com.campus.restaurante.dto.CreateUserDto;
import com.campus.restaurante.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<UserDto> findByEmailToCreate(String email);
    ResponseEntity<UserDto>createUser(CreateUserDto createUserDto);
}
