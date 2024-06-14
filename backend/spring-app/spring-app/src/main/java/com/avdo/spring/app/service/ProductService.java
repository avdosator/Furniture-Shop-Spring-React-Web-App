package com.avdo.spring.app.service;

import com.avdo.spring.app.dto.CreateProductRequest;
import com.avdo.spring.app.entity.Category;
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
    public ProductService(
            ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public void createProduct(CreateProductRequest createProductRequest) {
        Category category = categoryRepository
                .findCategoryByName(createProductRequest.getCategory())
                .orElseThrow(() -> new RuntimeException("Choose valid category!"));
        Product product = new ProductMapper().mapToProduct(createProductRequest, category);
        productRepository.save(product);
    }

    public List<Product> findAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public List<Product> findSameCategoryProducts(String category) {
        List<Product> products = productRepository.findByCategory_Name(category);
        return products;
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
