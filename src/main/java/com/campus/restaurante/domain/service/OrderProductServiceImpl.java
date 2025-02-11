
package com.campus.restaurante.domain.service;

import com.campus.restaurante.dto.ProductsDTO;
import com.campus.restaurante.persistence.entity.OrderProduct;
import com.campus.restaurante.persistence.entity.Orders;
import com.campus.restaurante.persistence.entity.Products;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderProductServiceImpl implements OrderProductService{

    //SELECT PRODUCT
//    @Transactional
//    @Override
//    public ResponseEntity<ProductsDTO> selectProduct(Long idProduct, int quantity, Long idOrder){
//        Optional<Products> productOpt = productRepository.findById(idProduct);
//        Optional<Orders> ordertOpt = orderRepository.findById(idProduct);
//        if (productOpt.isPresent()) {
//            OrderProduct product = new OrderProduct (ordertOpt.get(),quantity);
//            product.addPost(productOpt.get());
//
//            product = orderRepository.save(product);
//            System.out.println("product save.");
//            return true;
//        } else {
//            System.out.println("product with this id " + idProduct + " does not exist.");
//            return false;
//        }
//
//    }
    
}
