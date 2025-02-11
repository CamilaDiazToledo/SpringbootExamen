package com.campus.restaurante.web.controller;

import com.campus.restaurante.domain.service.AdminServiceImpl;
import com.campus.restaurante.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminServiceImpl adminServiceImpl;
    @Autowired
    public AdminController(AdminServiceImpl adminServiceImpl) {
        this.adminServiceImpl = adminServiceImpl;
    }

    //GET
    @GetMapping("/admin/all")
    public List<UserDto> getAllUsers() {
        return adminServiceImpl.getAllUsers();
    }

    @GetMapping("/admin/{email}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String email) {
        System.out.println("se va a imprimir");
        System.out.println(adminServiceImpl.getUserByEmail(email));
        return adminServiceImpl.getUserByEmail(email);
    }


    @PatchMapping("/admin/update/password/{email}")
    public void changePassword(@PathVariable String email,@RequestParam String currentPassword,@RequestParam String newPassword){
        adminServiceImpl.changePassword(email, currentPassword, newPassword);
    }
}
