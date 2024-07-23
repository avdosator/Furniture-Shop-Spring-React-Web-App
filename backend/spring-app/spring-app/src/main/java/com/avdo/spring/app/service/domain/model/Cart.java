package com.avdo.spring.app.service.domain.model;

import java.sql.Date;
import java.util.List;

public class Cart {

    private final Long id;
    private final User user;
    private final List<CartItem> cartItems;
    private final Date dateCreated;

    Cart(Long id, User user, List<CartItem> cartItems, Date dateCreated) {
        this.id = id;
        this.user = user;
        this.cartItems = cartItems;
        this.dateCreated = dateCreated;
    }

    public static CartBuilder builder() {
        return new CartBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public User getUser() {
        return this.user;
    }

    public List<CartItem> getCartItems() {
        return this.cartItems;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public static class CartBuilder {
        private Long id;
        private User user;
        private List<CartItem> cartItems;
        private Date dateCreated;

        CartBuilder() {
        }

        public CartBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CartBuilder user(User user) {
            this.user = user;
            return this;
        }

        public CartBuilder cartItems(List<CartItem> cartItems) {
            this.cartItems = cartItems;
            return this;
        }

        public CartBuilder dateCreated(Date dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public Cart build() {
            return new Cart(this.id, this.user, this.cartItems, this.dateCreated);
        }
    }

    public String toString() {
        return "Cart(id=" + this.getId() +
                ", userId=" + this.getUser().getId() +
                ", cartItems=" + this.getCartItems() +
                ", dateCreated=" + this.getDateCreated() + ")";
    }
}
