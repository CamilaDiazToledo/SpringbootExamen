package com.campus.restaurante.dto;


public class ProductsDTO {
    
    private Long idProduct;
    private String name;
    private Double price;
    private String details;

    public ProductsDTO() {
    }

    public ProductsDTO(Long idProduct, String name, Double price, String details) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.details = details;
    }

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

}
