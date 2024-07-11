package com.avdo.spring.app.controller.dto;

import com.avdo.spring.app.service.domain.request.CreateCategoryRequest;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateCategoryDto extends CreateCategoryRequest {

    @JsonCreator
    public CreateCategoryDto(@JsonProperty("name") String name) {
        super(name);
    }
    @NotBlank
    @Size(max = 30)
    @Override
    public String getName() {
        return name;
    }
}
