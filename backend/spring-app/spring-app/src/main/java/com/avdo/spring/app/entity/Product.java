package com.avdo.spring.app.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Product {

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

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<OrderItem> orderItems;

    public Product() {
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

    public List<OrderItem> getOrderItems() {
        return this.orderItems;
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

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String toString() {
        return "Product(id=" + this.getId() +
                ", name=" + this.getName() +
                ", price=" + this.getPrice() +
                ", stock=" + this.getStock() +
                ", description=" + this.getDescription() +
                ", categoryName=" + this.getCategoryEntity().getName() +
                /*", orderItems=" + this.getOrderItems() +*/ ")";
    }
}
