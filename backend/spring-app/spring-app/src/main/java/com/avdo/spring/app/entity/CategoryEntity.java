package com.avdo.spring.app.entity;

import com.avdo.spring.app.service.domain.model.CartItem;
import com.avdo.spring.app.service.domain.model.Category;
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
    private List<Product> products = new ArrayList<>();

    public Category toDomainModel() {
        /*List<Product> categories = (this.products == null ? Collections.emptyList() : this.products.stream()
                .map(Product::toDomainModel)
                .collect(Collectors.toList()));*/
        return Category.builder()
                .id(this.id)
                .name(this.name)
                .products(this.products)
                .build();
    }

    public CategoryEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String toString() {
        return "Category(id=" + this.getId() +
                ", name=" + this.getName() +
                /*", products=" + this.getProducts() +*/ ")";
    }
}
