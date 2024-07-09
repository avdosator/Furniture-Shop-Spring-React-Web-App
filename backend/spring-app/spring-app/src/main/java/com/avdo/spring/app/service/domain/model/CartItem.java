package com.avdo.spring.app.service.domain.model;

import com.avdo.spring.app.entity.Product;
import lombok.Builder;

import java.util.Date;

@Builder
public class CartItem {

    private Long id;

    private Long cartId;

    private Product product;

    private int quantity;

    private Date dateCreated;

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String toString() {
        return "CartItem(id=" + this.getId() +
                ", cartId=" + this.getCartId() +
                ", productId=" + this.getProduct().getId() +
                ", quantity=" + this.getQuantity() +
                ", dateCreated=" + this.getDateCreated() + ")";
    }
}
