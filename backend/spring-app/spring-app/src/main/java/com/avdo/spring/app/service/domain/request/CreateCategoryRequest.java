package com.avdo.spring.app.service.domain.request;

public class CreateCategoryRequest {

    protected final String name;

    public CreateCategoryRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
