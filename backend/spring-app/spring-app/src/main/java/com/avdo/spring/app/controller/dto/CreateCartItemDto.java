package com.avdo.spring.app.controller.dto;

import com.avdo.spring.app.service.domain.request.CreateCartItemRequest;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CreateCartItemDto extends CreateCartItemRequest {

    @JsonCreator
    public CreateCartItemDto(
            @JsonProperty("productId") Long productId,
            @JsonProperty("quantity") int quantity) {
        super(productId, quantity);
    }

    @NotNull
    @Min(1)
    @Override
    public Long getProductId() {
        return productId;
    }

    @Min(1)
    @Override
    public int getQuantity() {
        return quantity;
    }
}
