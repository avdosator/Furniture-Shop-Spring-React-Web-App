package com.avdo.spring.app.entity;

import com.avdo.spring.app.service.domain.model.Category;
import com.avdo.spring.app.service.domain.model.Product;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "category")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CategoryEntity {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String name;

    @OneToMany(mappedBy = "categoryEntity", fetch = FetchType.EAGER)
    private List<ProductEntity> productEntities = new ArrayList<>();

    public Category toDomainModel() {
        List<Product> products = (this.productEntities == null ? Collections.emptyList() : this.productEntities.stream()
                .map(ProductEntity::toDomainModel)
                .collect(Collectors.toList()));
        return Category.builder()
                .id(this.id)
                .name(this.name)
                .products(products)
                .build();
    }

    public static CategoryEntity fromCategory(Category category) {
        List<ProductEntity> productEntities = (category.getProducts() == null ? Collections.emptyList() : category.getProducts().stream()
                .map(ProductEntity::fromProduct) // You need to implement this method in ProductEntity
                .collect(Collectors.toList()));

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(category.getId());
        categoryEntity.setName(category.getName());
        categoryEntity.setProductEntities(productEntities);
        return categoryEntity;
    }

    public CategoryEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<ProductEntity> getProductEntities() {
        return this.productEntities;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductEntities(List<ProductEntity> productEntities) {
        this.productEntities = productEntities;
    }

    public String toString() {
        return "Category(id=" + this.getId() +
                ", name=" + this.getName() +
                /*", products=" + this.getProducts() +*/ ")";
    }
}
