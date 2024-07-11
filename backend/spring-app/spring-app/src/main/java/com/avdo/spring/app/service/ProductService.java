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
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductService(
            ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public ProductEntity createProduct(CreateProductRequest createProductRequest) {
        Category category = categoryRepository.findCategoryByName(createProductRequest.getCategory());
        ProductEntity product = ProductMapper.mapToProduct(createProductRequest, CategoryEntity.fromCategory(category));
        return productRepository.save(product);
    }

    public List<ProductEntity> findAllProducts() {
        return productRepository.findAll();
    }

    public ProductEntity findById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public List<ProductEntity> findSameCategoryProducts(String category) {
        return productRepository.findByCategoryEntity_Name(category);
    }

    private static class ProductMapper {

        private static ProductEntity mapToProduct(CreateProductRequest createProductRequest, CategoryEntity categoryEntity) {
            ProductEntity product = new ProductEntity();
            product.setName(createProductRequest.getName());
            product.setPrice(createProductRequest.getPrice());
            product.setStock(createProductRequest.getStock());
            product.setDescription(createProductRequest.getDescription());
            product.setCategoryEntity(categoryEntity);
            return product;
        }
    }
}
