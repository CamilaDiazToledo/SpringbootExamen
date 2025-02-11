package com.campus.restaurante.domain.repository;

import com.campus.restaurante.persistence.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long>{
    
}
