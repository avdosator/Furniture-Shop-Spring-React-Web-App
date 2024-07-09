package com.avdo.spring.app.service.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Setter
@Getter
@Builder
public class Cart {

    private Long id;

    private User user;

    private List<CartItem> cartItems;

    private Date dateCreated;

    public String toString() {
        return "Cart(id=" + this.getId() +
                ", userId=" + this.getUser().getId() +
                ", cartItems=" + this.getCartItems() +
                ", dateCreated=" + this.getDateCreated() + ")";
    }
}
