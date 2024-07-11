package com.avdo.spring.app.service.domain.model;

import com.avdo.spring.app.entity.CategoryEntity;
import com.avdo.spring.app.entity.OrderItem;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Product {

    private Long id;

    private String name;

    private double price;

    private int stock;

    private String description;

    private CategoryEntity categoryEntity;

    private List<OrderItem> orderItems;

    public String toString() {
        return "Product(id=" + this.getId() +
                ", name=" + this.getName() +
                ", price=" + this.getPrice() +
                ", stock=" + this.getStock() +
                ", description=" + this.getDescription() +
                ", category=" + this.categoryEntity.getName() + ")";
    }
}
