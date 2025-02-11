
package com.campus.restaurante.domain.service;


import com.campus.restaurante.dto.ProductsDTO;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<ProductsDTO> createProduct(String name, Double price, String details);
    Boolean updatePriceDescription(Long id, String details,double price);
    
}
