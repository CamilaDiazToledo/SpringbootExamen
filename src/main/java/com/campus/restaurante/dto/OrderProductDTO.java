
package com.campus.restaurante.dto;


public class OrderProductDTO {
    private Long idOrdersProducts;
    private String ProductName;
    private int quantity;

    public OrderProductDTO() {
    }

    public OrderProductDTO(Long idOrdersProducts, String ProductName, int quantity) {
        this.idOrdersProducts = idOrdersProducts;
        this.ProductName = ProductName;
        this.quantity = quantity;
    }

    public Long getIdOrdersProducts() {
        return idOrdersProducts;
    }

    public void setIdOrdersProducts(Long idOrdersProducts) {
        this.idOrdersProducts = idOrdersProducts;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
