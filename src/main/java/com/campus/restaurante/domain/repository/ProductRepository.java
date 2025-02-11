package com.campus.restaurante.domain.repository;

import com.campus.restaurante.dto.ProductsDTO;
import com.campus.restaurante.persistence.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface ProductRepository extends JpaRepository<Products, Long> {



}
