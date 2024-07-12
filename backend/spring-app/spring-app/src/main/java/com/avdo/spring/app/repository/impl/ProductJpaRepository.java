package com.avdo.spring.app.repository.impl;

import com.avdo.spring.app.entity.CategoryEntity;
import com.avdo.spring.app.entity.ProductEntity;
import com.avdo.spring.app.repository.ProductRepository;
import com.avdo.spring.app.repository.crud.CrudProductRepository;
import com.avdo.spring.app.service.CategoryService;
import com.avdo.spring.app.service.ProductService;
import com.avdo.spring.app.service.domain.model.Category;
import com.avdo.spring.app.service.domain.model.Product;
import com.avdo.spring.app.service.domain.request.CreateProductRequest;
import com.avdo.spring.app.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductJpaRepository implements ProductRepository {

    private final CrudProductRepository crudProductRepository;
    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    public ProductJpaRepository(CrudProductRepository crudProductRepository,
                                ProductService productService,
                                CategoryService categoryService) {
        this.crudProductRepository = crudProductRepository;
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @Override
    public Product createProduct(CreateProductRequest createProductRequest) {
        Category category = categoryService.findCategoryByName(createProductRequest.getCategory());
        ProductEntity product = ProductMapper.mapToProduct(createProductRequest, CategoryEntity.fromCategory(category));
        return crudProductRepository.save(product).toDomainModel();
    }

    @Override
    public List<Product> findAllProducts() {
        List<ProductEntity> productEntities = crudProductRepository.findAll();
        List<Product> products = new ArrayList<>();
        for (ProductEntity product : productEntities) {
            products.add(product.toDomainModel());
        }
        return products;
    }

    @Override
    public Product findById(Long id) {
        ProductEntity productEntity = crudProductRepository.findById(id).orElseThrow();
        return productEntity.toDomainModel();
    }

    @Override
    public List<Product> findSameCategoryProducts(String category) {
        List<ProductEntity> productEntities = crudProductRepository.findByCategoryEntity_Name(category);
        List<Product> products = new ArrayList<>();
        for (ProductEntity entity : productEntities) {
            products.add(entity.toDomainModel());
        }
        return products;
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
