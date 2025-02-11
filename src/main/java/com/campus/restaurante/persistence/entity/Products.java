/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.restaurante.persistence.entity;

import com.campus.restaurante.dto.CreateUserDto;
import com.campus.restaurante.dto.ProductsDTO;
import com.campus.restaurante.dto.UserDto;
import jakarta.persistence.*;

@Entity
public class Products {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    
    private String name;
    private Double price;
    private String details;

    @ManyToOne
    private OrderProduct orderProduct;
    //------------------CONTRUCTORES

    public Products() {
    }

    public Products(String name, Double price, String details) {
        this.name = name;
        this.price = price;
        this.details = details;
    }

    // ----------------- GETTER & SETTER


    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public OrderProduct getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(OrderProduct orderProduct) {
        this.orderProduct = orderProduct;
    }

    // ----------------- DTOS


    public ProductsDTO toDTO() {
        ProductsDTO productsDTO = new ProductsDTO();

        productsDTO.setName(this.name);

        productsDTO.setPrice(this.price);

        productsDTO.setDetails(this.details);

        return productsDTO;
    }
}
