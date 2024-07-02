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

    @Override
    public void setProductId(@NotNull @Min(1) Long productId) {
        super.setProductId(productId);
    }

    @Override
    public void setQuantity(@Min(1) int quantity) {
        super.setQuantity(quantity);
    }

}
