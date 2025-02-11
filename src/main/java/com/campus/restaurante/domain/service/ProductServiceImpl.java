
package com.campus.restaurante.domain.service;


import com.campus.restaurante.domain.repository.AdminRepository;
import com.campus.restaurante.domain.repository.ProductRepository;
import com.campus.restaurante.dto.CreateProductDTO;
import com.campus.restaurante.dto.ProductsDTO;
import com.campus.restaurante.dto.UserDto;
import com.campus.restaurante.persistence.entity.Admin;
import com.campus.restaurante.persistence.entity.Products;
import com.campus.restaurante.persistence.entity.Users;
import com.campus.restaurante.web.exceptions.DataInUseException;
import com.campus.restaurante.web.exceptions.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;




    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
        
    }

    //CREATE
    @Transactional
    @Override
    public ResponseEntity<CreateProductDTO> createProduct(CreateProductDTO createProductDTO ) {

        Products product = Products.fromDTOCreate(createProductDTO);
        product = productRepository.save(product);
        return ResponseEntity.ok(product.toDTOCreate());
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


    //GET.........................................................................
    //todos por idPost
    @Transactional
    @Override
    public List<ProductsDTO> getAllProducts() {

        List<Products> users = productRepository.findAll();
        if (users.isEmpty()) {
            throw new NotFoundException("No users found");
        }
        return users.stream()
                .map(Products::toDTO)
                .collect(Collectors.toList());
    }





}