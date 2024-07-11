package com.avdo.spring.app.service;

import com.avdo.spring.app.entity.CategoryEntity;
import com.avdo.spring.app.entity.ProductEntity;
import com.avdo.spring.app.repository.CategoryRepository;
import com.avdo.spring.app.repository.ProductRepository;
import com.avdo.spring.app.service.domain.model.Category;
import com.avdo.spring.app.service.domain.request.CreateProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    ProductEntity createProduct(CreateProductRequest createProductRequest);
    List<ProductEntity> findAllProducts();
    public ProductEntity findById(Long id);
    List<ProductEntity> findSameCategoryProducts(String category);
}
