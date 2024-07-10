package com.avdo.spring.app.service.domain.model;

import com.avdo.spring.app.entity.Product;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Category {

    private Long id;

    private String name;

    private List<Product> products;

    public String toString() {
        return "Category(id=" + this.getId() +
                ", name=" + this.getName() +  ")";
    }
}
