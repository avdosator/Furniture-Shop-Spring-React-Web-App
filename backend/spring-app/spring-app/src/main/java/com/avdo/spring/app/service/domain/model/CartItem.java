package com.avdo.spring.app.service.domain.model;

import com.avdo.spring.app.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Builder
public class CartItem {

    private Long id;

    private Long cartId;

    private Product product;

    private int quantity;

    private Date dateCreated;

    public String toString() {
        return "CartItem(id=" + this.getId() +
                ", cartId=" + this.getCartId() +
                ", productId=" + this.getProduct().getId() +
                ", quantity=" + this.getQuantity() +
                ", dateCreated=" + this.getDateCreated() + ")";
    }
}
