package com.avdo.spring.app.service.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateProductRequest {

    protected final String name;

    protected final double price;

    protected final int stock;

    protected final String description;

    protected final String category;
}
