package com.avdo.spring.app.service.domain.request;

public class CreateOrderRequest {

    protected final Long cartId;

    public CreateOrderRequest(Long cartId) {
        this.cartId = cartId;
    }

    public Long getCartId() {
        return this.cartId;
    }
}
