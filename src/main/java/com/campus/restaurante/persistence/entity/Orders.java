package com.campus.restaurante.persistence.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Orders {
    // ----------------- ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder;

    @ManyToOne
    private Users user;

    @ManyToOne
    private Admin admin;


    private String estado;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderProduct> orderProducts = new ArrayList<>();

    private double total;

    //------------------CONTRUCTORES

    public Orders() {
    }

    public Orders(Users user, Admin admin, String estado, double total) {
        this.user = user;
        this.admin = admin;
        this.estado = estado;
        this.total = total;
    }


    // ----------------- GETTER & SETTER


    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<OrderProduct> getOrderProduct() {
        return orderProducts;
    }

    public void setOrderProduct(List<OrderProduct> orderProduct) {
        this.orderProducts = orderProduct;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    // ----------------- LIST FIXED
    //ORDERS
    public void addPost(OrderProduct orderProduct) {
        this.orderProducts.add(orderProduct);
        orderProduct.setOrder(this);
    }

    public void removePost(OrderProduct orderProduct){
        this.orderProducts.remove(orderProduct);
        orderProduct.setOrder(null);
    }


}
