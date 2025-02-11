/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.restaurante.persistence.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderProduct {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrdersProducts;
    

    
    @ManyToOne
    @JoinColumn(name = "idOrder")
    private Orders order;
    
    private int quantity;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Products> products = new ArrayList<>();
    //------------------CONTRUCTORES


    public OrderProduct() {
    }

    public OrderProduct(Orders order, int quantity) {
        this.order = order;
        this.quantity = quantity;
    }

    // ----------------- GETTER & SETTER
    public Long getIdOrdersProducts() {
        return idOrdersProducts;
    }

    public void setIdOrdersProducts(Long idOrdersProducts) {
        this.idOrdersProducts = idOrdersProducts;
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


    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    // ----------------- LIST FIXED
    //ORDERS
    public void addPost(Products product) {
        this.products.add(product);
        product.setOrderProduct(this);
    }

    public void removePost(Products product){
        this.products.remove(product);
        product.setOrderProduct(null);
    }


}
