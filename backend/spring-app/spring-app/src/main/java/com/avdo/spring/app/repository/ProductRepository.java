package com.avdo.spring.app.repository;

import com.avdo.spring.app.entity.ProductEntity;
import com.avdo.spring.app.service.domain.model.Product;
import com.avdo.spring.app.service.domain.request.CreateProductRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductRepository {

    Product createProduct(CreateProductRequest createProductRequest);
}
