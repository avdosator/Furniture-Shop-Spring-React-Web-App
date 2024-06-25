package com.avdo.spring.app.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateCategoryRequest {

    @NotBlank
    @Size(max = 30)
    private String name;
}
