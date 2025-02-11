package com.campus.restaurante.persistence.entity;

import com.campus.restaurante.dto.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;


/**
 *
 * @author camid
 */
@Entity
public class Users {
    // ----------------- ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(nullable = false, length = 100)
    private String name;


    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 1000)
    private String password;


    // ----------------- LISTAS


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Orders> orders = new ArrayList<>();


    // ----------------- CONSTRUCTORES

    public Users(){

    }
    public Users(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // ----------------- GETTER & SETTER


    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    // ----------------- LIST FIXED
    //ORDERS
    public void addPost(Orders order) {
        this.orders.add(order);
        order.setUser(this);
    }

    public void removePost(Orders order){
        this.orders.remove(order);
        order.setUser(null);
    }


    // ----------------- DTOS

//    public CreateUserDto toDTOCreate() {
//        CreateUserDto createUserDTO = new CreateUserDto();
//        createUserDTO.setName(this.name);
//        createUserDTO.setEmail(this.email);
//        createUserDTO.setPassword(this.password);
//        createUserDTO.setUserName(this.userName);
//        return createUserDTO;
//
//    }
//
//    public  static  Users fromDTOCreate( CreateUserDto createUserDTO){
//        Users user = new Users();
//        user.setName(createUserDTO.getName());
//        user.setUserName(createUserDTO.getUserName());
//        user.setEmail(createUserDTO.getEmail());
//        user.setPassword(createUserDTO.getPassword());
//        user.setActive(Boolean.TRUE);
//        user.setCreationDate(new Date());
//        user.setBiography("New Biography");
//
//        return  user;
//    }
//
//    public UserDto toDTO() {
//        UserDto usersDTO = new UserDto();
//        usersDTO.setBiography(this.biography);
//        usersDTO.setCreationDate(this.creationDate);
//        usersDTO.setUpdatedAt(this.updatedAt);
//        usersDTO.setName(this.name);
//        usersDTO.setUserName(this.userName);
//        usersDTO.setEmail(this.email);
//        usersDTO.setPhoto(this.photo);
//        usersDTO.setLastLogin(this.lastLogin);
//        usersDTO.setActive(this.active);
//        usersDTO.setUserName(this.userName);
//        usersDTO.setFriend(Boolean.FALSE);
//        return usersDTO;
//
//
//    }


}

