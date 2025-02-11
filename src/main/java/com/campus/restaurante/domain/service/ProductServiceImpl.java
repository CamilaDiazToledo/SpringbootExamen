
package com.campus.restaurante.domain.service;


import com.campus.restaurante.domain.repository.AdminRepository;
import com.campus.restaurante.domain.repository.ProductRepository;
import com.campus.restaurante.dto.ProductsDTO;
import com.campus.restaurante.persistence.entity.Admin;
import com.campus.restaurante.persistence.entity.Products;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final AdminRepository adminRepository;



    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, AdminRepository adminRepository) {
        this.productRepository = productRepository;
        this.adminRepository = adminRepository;
    }

    //CREATE
    @Transactional
    @Override
    public ResponseEntity<ProductsDTO> createProduct(String name, Double price, String details) {
        Products product = new Products(name, price, details);
        product = productRepository.save(product);
        ProductsDTO productsDTO = product.toDTO();
        return ResponseEntity.ok(productsDTO);
    }

    //UPDATE
    @Transactional
    @Override
    public Boolean updatePriceDescription(Long id, String details,double price) {
        Optional<Products> productOpt = productRepository.findById(id);

        if (productOpt.isPresent()) {
            Products product = productOpt.get();
            product.setDetails(details);
            product.setPrice(price);

            productRepository.save(product);
            System.out.println("product updated.");
            return true;
        } else {
            System.out.println("product with this id " + id + " does not exist.");
            return false;
        }
    }





}


