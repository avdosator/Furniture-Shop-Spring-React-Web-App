package com.avdo.spring.app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateProductRequest {

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotNull
    private double price;

    @NotNull
    private int stock;

    private String description;

    @NotBlank
    private String category;
}
