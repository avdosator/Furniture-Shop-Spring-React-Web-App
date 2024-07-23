package com.avdo.spring.app.service.domain.request;

public class CreateProductRequest {

    protected final String name;
    protected final double price;
    protected final int stock;
    protected final String description;
    protected final String category;

    public CreateProductRequest(String name, double price, int stock, String description, String category) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.category = category;
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

    public String getCategory() {
        return this.category;
    }
}
