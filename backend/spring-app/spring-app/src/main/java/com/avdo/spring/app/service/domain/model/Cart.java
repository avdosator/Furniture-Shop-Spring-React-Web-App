package com.avdo.spring.app.service.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.sql.Date;
import java.util.List;

@Getter
@Builder
public class Cart {

    private final Long id;

    private final User user;

    private final List<CartItem> cartItems;

    private final Date dateCreated;

    public String toString() {
        return "Cart(id=" + this.getId() +
                ", userId=" + this.getUser().getId() +
                ", cartItems=" + this.getCartItems() +
                ", dateCreated=" + this.getDateCreated() + ")";
    }
}
