package com.avdo.spring.app.controller.dto;

import com.avdo.spring.app.service.domain.request.CreateProductRequest;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class CreateProductDto extends CreateProductRequest {

    @JsonCreator
    public CreateProductDto(@JsonProperty("name") String name,
                            @JsonProperty("price") double price,
                            @JsonProperty("stock") int stock,
                            @JsonProperty("description") String description,
                            @JsonProperty("category") String category) {
        super(name, price, stock, description, category);
    }
    @NotBlank
    @Size(max = 50)
    @Override
    public String getName() {
        return name;
    }

    @NotNull
    @Override
    public double getPrice() {
        return price;
    };

    @NotNull
    @Override
    public int getStock() {
        return stock;
    };

    @Override
    public String getDescription() {
        return description;
    };

    @NotBlank
    @Size(max = 30)
    @Override
    public String getCategory() {
        return category;
    };
}
