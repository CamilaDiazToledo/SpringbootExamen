package com.campus.restaurante.web.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message){
        super(message);
    }
}