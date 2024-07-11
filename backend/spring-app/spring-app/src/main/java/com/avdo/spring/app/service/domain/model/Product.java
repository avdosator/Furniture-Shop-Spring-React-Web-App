package com.avdo.spring.app.service.domain.model;

import com.avdo.spring.app.entity.OrderItem;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Product {

    private final Long id;

    private final String name;

    private final double price;

    private final int stock;

    private final String description;

    private final Category category;

    private final List<OrderItem> orderItems;

    public String toString() {
        return "Product(id=" + this.getId() +
                ", name=" + this.getName() +
                ", price=" + this.getPrice() +
                ", stock=" + this.getStock() +
                ", description=" + this.getDescription() +
                ", category=" + this.category.getName() + ")";
    }
}
