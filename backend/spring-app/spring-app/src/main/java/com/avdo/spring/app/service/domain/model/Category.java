package com.avdo.spring.app.service.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Category {

    private final Long id;

    private final String name;

    private final List<Product> products;

    public String toString() {
        return "Category(id=" + this.getId() +
                ", name=" + this.getName() +  ")";
    }
}
