package com.avdo.spring.app.service.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.sql.Date;
import java.util.List;

@Builder
@Getter
public class Order {

    private final Long id;
    private final User user;
    private final List<OrderItem> orderItems;
    private final double totalAmount;
    private final String orderStatus;
    private final Date dateCreated;

    public String toString() {
        return "Order(id=" + this.getId() +
                ", userId=" + this.getUser().getId() +
                ", orderItems=" + this.getOrderItems() +
                ", totalAmount=" + this.getTotalAmount() +
                ", orderStatus=" + this.getOrderStatus() +
                ", dateCreated=" + this.getDateCreated() + ")";
    }
}
