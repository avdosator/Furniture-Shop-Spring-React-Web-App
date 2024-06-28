package com.avdo.spring.app.controller.dto;

import com.avdo.spring.app.service.domain.request.CreateCartItemRequest;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

public class CreateCartItemDto extends CreateCartItemRequest {

    //@NotNull
    //@Min(1)
    private Long productId;

    //@Min(1)
    private int quantity;

    @JsonCreator
    public CreateCartItemDto(
            @JsonProperty("productId") @NotNull @Min(1) Long productId,
            @JsonProperty("quantity") @Min(1) int quantity) {
        super(productId, quantity);
    }
}
