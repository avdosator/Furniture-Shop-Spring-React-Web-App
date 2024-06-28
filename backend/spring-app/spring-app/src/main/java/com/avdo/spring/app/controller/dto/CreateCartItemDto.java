package com.avdo.spring.app.controller.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateCartItemDto {

    @NotNull
    @Min(1)
    private Long productId;

    @Min(1)
    private int quantity;

}
