/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.restaurante.web.exceptions;

public class ActionNotAllowed extends RuntimeException{
    public ActionNotAllowed(String message){
        super(message);
    }
}
