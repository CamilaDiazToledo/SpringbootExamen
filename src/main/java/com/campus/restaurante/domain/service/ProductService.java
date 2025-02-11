
package com.campus.restaurante.domain.service;


import com.campus.restaurante.dto.CreateProductDTO;
import com.campus.restaurante.dto.ProductsDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<CreateProductDTO> createProduct(CreateProductDTO createProductDTO);
    Boolean updatePriceDescription(Long id, String details,double price);

    List<ProductsDTO> getAllUsers();
    
}
