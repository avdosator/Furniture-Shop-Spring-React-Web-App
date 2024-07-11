package com.avdo.spring.app.service.domain.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateProductRequest {
    @NotBlank
    @Size(max = 50)
    private final String name;

    @NotNull
    private final double price;

    @NotNull
    private final int stock;

    private final String description;

    @NotBlank
    @Size(max = 30)
    private final String category;
}
