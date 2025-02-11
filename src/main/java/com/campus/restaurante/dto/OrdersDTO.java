
package com.campus.restaurante.dto;

import com.campus.restaurante.persistence.entity.Admin;
import com.campus.restaurante.persistence.entity.OrderProduct;
import com.campus.restaurante.persistence.entity.Users;
import java.util.ArrayList;
import java.util.List;

public class OrdersDTO {
    
    private Long idOrder;
    private String estado;
    private List<OrderProduct> orderProducts = new ArrayList<>();
    private double total;

    public OrdersDTO() {
    }

    public OrdersDTO(Long idOrder, String estado, double total) {
        this.idOrder = idOrder;
        this.estado = estado;
        this.total = total;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
