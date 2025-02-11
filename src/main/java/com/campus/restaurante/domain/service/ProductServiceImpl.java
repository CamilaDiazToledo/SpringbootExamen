
package com.campus.restaurante.domain.service;


import com.campus.restaurante.domain.repository.ProductRepository;
import com.campus.restaurante.dto.ProductsDTO;
import com.campus.restaurante.persistence.entity.Products;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //CREATE
//    @Transactional
//    @Override
//    public ResponseEntity<ProductsDTO> createProduct(String name, Double price, String details) {
//        Products product = new Products(name, price, details);
//        product = productRepository.save(product);
//        ProductsDTO productsDTO = product.toDTO();
//        return ResponseEntity.ok(productsDTO);
//    }
//
//    //UPDATE
//    @Transactional
//    @Override
//    public Boolean updateBiography(String details, Double price) {
//        Optional<Users> userOpt = userRepositorty.findByEmail(email);
//
//        if (userOpt.isPresent()) {
//            Users user = userOpt.get();
//            user.setBiography(biography);
//            user.setUpdatedAt(new Date());
//
//            userRepositorty.save(user);
//            System.out.println("biography profile updated.");
//            return true;
//        } else {
//            System.out.println("User with this email " + email + " does not exist.");
//            return false;
//        }
//    }
}


