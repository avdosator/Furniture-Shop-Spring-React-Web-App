package com.avdo.spring.app.controller.dto;

import com.avdo.spring.app.service.domain.request.CreateOrderRequest;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CreateOrderDto extends CreateOrderRequest {

    @JsonCreator
    public CreateOrderDto(@JsonProperty("cartId") Long cartId) {
        super(cartId);
    }

    @Override
    @NotNull
    @Min(1)
    public Long getCartId() {
        return cartId;
    }
}
