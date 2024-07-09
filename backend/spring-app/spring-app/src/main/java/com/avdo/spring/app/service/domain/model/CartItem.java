package com.avdo.spring.app.service.domain.model;

import com.avdo.spring.app.entity.Product;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class CartItem {

    private final Long id;

    private final Long cartId;

    private final Product product;

    private final int quantity;

    private final Date dateCreated;

    public String toString() {
        return "CartItem(id=" + this.getId() +
                ", cartId=" + this.getCartId() +
                ", productId=" + this.getProduct().getId() +
                ", quantity=" + this.getQuantity() +
                ", dateCreated=" + this.getDateCreated() + ")";
    }
}
