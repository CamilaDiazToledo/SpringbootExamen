package com.campus.restaurante.web.controller;

import com.campus.restaurante.domain.service.ProductServiceImpl;
import com.campus.restaurante.dto.CreateProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductServiceImpl productServiceImpl;
    @Autowired
    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateProductDTO> createProduct(@RequestBody CreateProductDTO createProductDTO) {
        System.out.println("Recibiendo solicitud para crear product: " + createProductDTO);
        return productServiceImpl.createProduct(createProductDTO);
    }



}
