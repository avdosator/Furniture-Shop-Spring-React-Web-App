package com.avdo.spring.app.service.domain.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OrderItem {

    private final Long id;
    private final Order order;
    private final int quantity;
    private final double price;
    private final Product product;

    public String toString() {
        return "OrderItem(id=" + this.getId() +
                ", orderId=" + this.getOrder().getId() +
                ", quantity=" + this.getQuantity() +
                ", price=" + this.getPrice() +
                ", productId=" + this.getProduct().getId() + ")";
    }
}
