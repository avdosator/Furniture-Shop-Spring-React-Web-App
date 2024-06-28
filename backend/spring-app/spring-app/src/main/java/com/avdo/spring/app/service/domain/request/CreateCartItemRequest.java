package com.avdo.spring.app.service.domain.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CreateCartItemRequest {

    @NotNull
    @Min(1)
    private Long productId;

    @Min(1)
    private int quantity;
}
