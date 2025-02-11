package com.campus.restaurante.dto;

public class CreateProductDTO {
    private String name;
    private Double price;
    private String details;

    public CreateProductDTO() {
    }

    public CreateProductDTO( String name, Double price, String details) {

        this.name = name;
        this.price = price;
        this.details = details;
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
