package com.avdo.spring.app.service.domain.model;

import java.util.List;

public class Product {

    private final Long id;
    private final String name;
    private final double price;
    private final int stock;
    private final String description;
    private final Category category;
    private final List<OrderItem> orderItems;

    Product(Long id, String name, double price, int stock, String description, Category category, List<OrderItem> orderItems) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.category = category;
        this.orderItems = orderItems;
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
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

    public Category getCategory() {
        return this.category;
    }

    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    public static class ProductBuilder {
        private Long id;
        private String name;
        private double price;
        private int stock;
        private String description;
        private Category category;
        private List<OrderItem> orderItems;

        ProductBuilder() {
        }

        public ProductBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder price(double price) {
            this.price = price;
            return this;
        }

        public ProductBuilder stock(int stock) {
            this.stock = stock;
            return this;
        }

        public ProductBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder category(Category category) {
            this.category = category;
            return this;
        }

        public ProductBuilder orderItems(List<OrderItem> orderItems) {
            this.orderItems = orderItems;
            return this;
        }

        public Product build() {
            return new Product(this.id, this.name, this.price, this.stock, this.description, this.category, this.orderItems);
        }
    }

    public String toString() {
        return "Product(id=" + this.getId() +
                ", name=" + this.getName() +
                ", price=" + this.getPrice() +
                ", stock=" + this.getStock() +
                ", description=" + this.getDescription() +
                ", categoryName=" + this.category.getName() + ")";
    }
}
