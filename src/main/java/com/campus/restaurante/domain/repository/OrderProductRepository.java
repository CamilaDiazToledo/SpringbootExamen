package com.campus.restaurante.domain.repository;

import com.campus.restaurante.persistence.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderProductRepository extends JpaRepository<OrderProduct, Long>{
    
}
