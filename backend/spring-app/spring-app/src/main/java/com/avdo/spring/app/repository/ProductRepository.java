package com.avdo.spring.app.repository;

import com.avdo.spring.app.service.domain.model.Product;
import com.avdo.spring.app.service.domain.request.CreateProductRequest;

import java.util.List;

public interface ProductRepository {

    Product createProduct(CreateProductRequest createProductRequest);
    List<Product> findAllProducts();
    Product findById(Long id);
    List<Product> findSameCategoryProducts(String category);
}
