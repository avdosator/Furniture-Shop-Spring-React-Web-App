package com.avdo.spring.app.service.domain.model;

import java.sql.Date;
import java.util.List;

public class Order {

    private final Long id;
    private final User user;
    private final List<OrderItem> orderItems;
    private final double totalAmount;
    private final String orderStatus;
    private final Date dateCreated;

    Order(Long id, User user, List<OrderItem> orderItems, double totalAmount, String orderStatus, Date dateCreated) {
        this.id = id;
        this.user = user;
        this.orderItems = orderItems;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
        this.dateCreated = dateCreated;
    }

    public static OrderBuilder builder() {
        return new OrderBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public User getUser() {
        return this.user;
    }

    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    public double getTotalAmount() {
        return this.totalAmount;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public static class OrderBuilder {
        private Long id;
        private User user;
        private List<OrderItem> orderItems;
        private double totalAmount;
        private String orderStatus;
        private Date dateCreated;

        OrderBuilder() {
        }

        public OrderBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public OrderBuilder user(User user) {
            this.user = user;
            return this;
        }

        public OrderBuilder orderItems(List<OrderItem> orderItems) {
            this.orderItems = orderItems;
            return this;
        }

        public OrderBuilder totalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public OrderBuilder orderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public OrderBuilder dateCreated(Date dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public Order build() {
            return new Order(this.id, this.user, this.orderItems, this.totalAmount, this.orderStatus, this.dateCreated);
        }
    }

    public String toString() {
        return "Order(id=" + this.getId() +
                ", userId=" + this.getUser().getId() +
                ", orderItems=" + this.getOrderItems() +
                ", totalAmount=" + this.getTotalAmount() +
                ", orderStatus=" + this.getOrderStatus() +
                ", dateCreated=" + this.getDateCreated() + ")";
    }
}
