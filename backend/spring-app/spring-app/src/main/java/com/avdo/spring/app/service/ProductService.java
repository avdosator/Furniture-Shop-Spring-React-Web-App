package com.avdo.spring.app.service;

import com.avdo.spring.app.entity.CategoryEntity;
import com.avdo.spring.app.entity.ProductEntity;
import com.avdo.spring.app.repository.CategoryRepository;
import com.avdo.spring.app.repository.ProductRepository;
import com.avdo.spring.app.service.domain.model.Category;
import com.avdo.spring.app.service.domain.model.Product;
import com.avdo.spring.app.service.domain.request.CreateProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    Product createProduct(CreateProductRequest createProductRequest);
    List<Product> findAllProducts();
    Product findById(Long id);
    List<Product> findSameCategoryProducts(String category);
}
