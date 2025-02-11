/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.restaurante.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderProduct {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrdersProducts;
    
    @ManyToOne
    @JoinColumn(name = "idProduct")
    private Products product;
    
    @ManyToOne
    @JoinColumn(name = "idOrder")
    private Orders order;
    
    private int quantity;

    public OrderProduct(Long idOrdersProducts, Products product, Orders order, int quantity) {
        this.idOrdersProducts = idOrdersProducts;
        this.product = product;
        this.order = order;
        this.quantity = quantity;
    }

    public Long getIdOrdersProducts() {
        return idOrdersProducts;
    }

    public void setIdOrdersProducts(Long idOrdersProducts) {
        this.idOrdersProducts = idOrdersProducts;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
