package com.avdo.spring.app.repository.entity;

import com.avdo.spring.app.service.domain.model.Product;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "product")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ProductEntity {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "stock")
    private int stock;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    @OneToMany(mappedBy = "productEntity", fetch = FetchType.EAGER)
    private List<OrderItemEntity> orderItemEntities;

    public ProductEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getStock() {
        return this.stock;
    }

    public String getDescription() {
        return this.description;
    }

    public CategoryEntity getCategoryEntity() {
        return this.categoryEntity;
    }

    public List<OrderItemEntity> getOrderItems() {
        return this.orderItemEntities;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public void setOrderItems(List<OrderItemEntity> orderItemEntities) {
        this.orderItemEntities = orderItemEntities;
    }

    public Product toDomainModel() {
        return Product.builder()
                .id(this.id)
                .name(this.name)
                .price(this.price)
                .stock(this.stock)
                .description(this.description)
                .category(this.categoryEntity.toDomainModel())
                .build();
    }

    public String toString() {
        return "Product(id=" + this.getId() +
                ", name=" + this.getName() +
                ", price=" + this.getPrice() +
                ", stock=" + this.getStock() +
                ", description=" + this.getDescription() +
                ", categoryName=" + this.getCategoryEntity().getName() + ")";
    }
}
