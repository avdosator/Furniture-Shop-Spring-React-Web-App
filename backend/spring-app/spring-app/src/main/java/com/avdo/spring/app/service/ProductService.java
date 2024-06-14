package com.avdo.spring.app.service;

import com.avdo.spring.app.dto.CreateProductRequest;
import com.avdo.spring.app.entity.Category;
import com.avdo.spring.app.entity.Product;
import com.avdo.spring.app.repository.CategoryRepository;
import com.avdo.spring.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductService(
            ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public void createProduct(CreateProductRequest createUserRequest) {
        Category category = categoryRepository
                .findCategoryByName(createUserRequest.getName())
                .orElseThrow(() -> new RuntimeException());
        Product product = new ProductMapper().mapToProduct(createUserRequest, category);
        productRepository.save(product);
    }

    private class ProductMapper {

        private Product mapToProduct(CreateProductRequest createProductRequest, Category category) {
            Product product = new Product();
            product.setName(createProductRequest.getName());
            product.setPrice(createProductRequest.getPrice());
            product.setStock(createProductRequest.getStock());
            product.setDescription(createProductRequest.getDescription());
            product.setCategory(category);
            return product;
        }
    }
}
