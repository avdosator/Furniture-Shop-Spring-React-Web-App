package com.avdo.spring.app.service.domain.model;

public class OrderItem {

    private final Long id;
    private final Long orderId;
    private final int quantity;
    private final double price;
    private final Product product;

    OrderItem(Long id, Long orderId, int quantity, double price, Product product) {
        this.id = id;
        this.orderId = orderId;
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public static OrderItemBuilder builder() {
        return new OrderItemBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public Product getProduct() {
        return this.product;
    }

    public static class OrderItemBuilder {
        private Long id;
        private Long orderId;
        private int quantity;
        private double price;
        private Product product;

        OrderItemBuilder() {
        }

        public OrderItemBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public OrderItemBuilder orderId(Long orderId) {
            this.orderId = orderId;
            return this;
        }

        public OrderItemBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public OrderItemBuilder price(double price) {
            this.price = price;
            return this;
        }

        public OrderItemBuilder product(Product product) {
            this.product = product;
            return this;
        }

        public OrderItem build() {
            return new OrderItem(this.id, this.orderId, this.quantity, this.price, this.product);
        }
    }

    public String toString() {
        return "OrderItem(id=" + this.getId() +
                ", orderId=" + this.getOrderId() +
                ", quantity=" + this.getQuantity() +
                ", price=" + this.getPrice() +
                ", productId=" + this.getProduct().getId() + ")";
    }
}
