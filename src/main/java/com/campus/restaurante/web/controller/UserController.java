package com.campus.restaurante.web.controller;

import com.campus.restaurante.domain.service.UserServiceImpl;
import com.campus.restaurante.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserServiceImpl userServiceimpl;

    @Autowired
    public UserController(UserServiceImpl userServiceimpl) {
        this.userServiceimpl = userServiceimpl;
    }

    //GET
    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        return userServiceimpl.getAllUsers();
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String email) {
        System.out.println("se va a imprimir");
        System.out.println(userServiceimpl.getUserByEmail(email));
        return userServiceimpl.getUserByEmail(email);
    }


    @PatchMapping("/update/password/{email}")
    public void changePassword(@PathVariable String email,@RequestParam String currentPassword,@RequestParam String newPassword){
        userServiceimpl.changePassword(email, currentPassword, newPassword);
    }

}
