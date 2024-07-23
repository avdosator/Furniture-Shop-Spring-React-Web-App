package com.avdo.spring.app.service.impl;

import com.avdo.spring.app.repository.ProductRepository;
import com.avdo.spring.app.service.ProductService;
import com.avdo.spring.app.service.domain.model.Product;
import com.avdo.spring.app.service.domain.request.CreateProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(CreateProductRequest createProductRequest) {
        return productRepository.createProduct(createProductRequest);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAllProducts();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findSameCategoryProducts(String category) {
        return productRepository.findSameCategoryProducts(category);
    }

}
