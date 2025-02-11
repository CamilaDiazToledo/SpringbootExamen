package com.campus.restaurante.persistence.entity;

import com.campus.restaurante.dto.CreateUserDto;
import com.campus.restaurante.dto.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdmin;
    
    private String name;
    private String email;
    private String password;

    public Admin() {
    }

    public Admin(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Long idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // ----------------- DTOS

    public CreateUserDto toDTOCreate() {
        CreateUserDto createUserDTO = new CreateUserDto();
        createUserDTO.setName(this.name);
        createUserDTO.setEmail(this.email);
        createUserDTO.setPassword(this.password);
        return createUserDTO;

    }

    public  static  Admin fromDTOCreate( CreateUserDto createUserDTO){
        Admin user = new Admin();
        user.setName(createUserDTO.getName());
        user.setEmail(createUserDTO.getEmail());
        user.setPassword(createUserDTO.getPassword());
        return  user;
    }

    public UserDto toDTO() {
        UserDto usersDTO = new UserDto();

        usersDTO.setName(this.name);

        usersDTO.setEmail(this.email);

        return usersDTO;


    }
}
