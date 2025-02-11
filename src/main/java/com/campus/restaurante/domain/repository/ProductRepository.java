package com.campus.restaurante.domain.repository;

import com.campus.restaurante.persistence.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {

}
