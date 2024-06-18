package com.avdo.spring.app.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateOrderItemRequest {

    @NotBlank
    private String username;

    @NotEmpty
    @Min(1)
    private Long productId;

    @Min(1)
    private int quantity;

}
