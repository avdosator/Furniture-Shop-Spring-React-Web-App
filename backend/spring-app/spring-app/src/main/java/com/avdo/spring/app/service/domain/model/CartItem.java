package com.avdo.spring.app.service.domain.model;

import java.util.Date;

public class CartItem {

    private final Long id;
    private final Long cartId;
    private final Product product;
    private final int quantity;
    private final Date dateCreated;

    CartItem(Long id, Long cartId, Product product, int quantity, Date dateCreated) {
        this.id = id;
        this.cartId = cartId;
        this.product = product;
        this.quantity = quantity;
        this.dateCreated = dateCreated;
    }

    public static CartItemBuilder builder() {
        return new CartItemBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public Long getCartId() {
        return this.cartId;
    }

    public Product getProduct() {
        return this.product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public static class CartItemBuilder {
        private Long id;
        private Long cartId;
        private Product product;
        private int quantity;
        private Date dateCreated;

        CartItemBuilder() {
        }

        public CartItemBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CartItemBuilder cartId(Long cartId) {
            this.cartId = cartId;
            return this;
        }

        public CartItemBuilder product(Product product) {
            this.product = product;
            return this;
        }

        public CartItemBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public CartItemBuilder dateCreated(Date dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public CartItem build() {
            return new CartItem(this.id, this.cartId, this.product, this.quantity, this.dateCreated);
        }
    }

    public String toString() {
        return "CartItem(id=" + this.getId() +
                ", cartId=" + this.getCartId() +
                ", productId=" + this.getProduct().getId() +
                ", quantity=" + this.getQuantity() +
                ", dateCreated=" + this.getDateCreated() + ")";
    }
}
