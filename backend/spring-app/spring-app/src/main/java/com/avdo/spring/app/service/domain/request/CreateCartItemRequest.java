package com.avdo.spring.app.service.domain.request;

public class CreateCartItemRequest {

    protected final Long productId;
    protected final int quantity;

    public CreateCartItemRequest(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return this.productId;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
