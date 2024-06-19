package com.avdo.spring.app.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateCartItemRequest {

    //@NotBlank
    //private String username;

    @NotNull
    @Min(1)
    private Long productId;

    @Min(1)
    private int quantity;

}
