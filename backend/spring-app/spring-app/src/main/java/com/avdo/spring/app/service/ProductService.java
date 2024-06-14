package com.avdo.spring.app.service;

import com.avdo.spring.app.entity.Product;
import com.avdo.spring.app.repository.CategoryRepository;
import com.avdo.spring.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public void createUser(CreateProductRequest createUserRequest) {

        Product product = new ProductMapper().mapToProduct(createUserRequest);
        productRepository.save(product);
    }

    private class ProductMapper {

        private Product mapToProduct(CreateProductRequest createProductRequest) {

        }
    }
}
