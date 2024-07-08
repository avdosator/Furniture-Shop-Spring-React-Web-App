package com.avdo.spring.app.service.domain.model;

import com.avdo.spring.app.entity.Product;
import lombok.Builder;

import java.util.Date;

@Builder
public class CartItem {

    private Long id;

    private Cart cart;

    private Product product;

    private int quantity;

    private Date dateCreated;

    public Long getId() {
        return this.id;
    }

    public Cart getCart() {
        return this.cart;
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

    public void setCart(Cart cart) {
        this.cart = cart;
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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CartItem)) return false;
        final CartItem other = (CartItem) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$cart = this.getCart();
        final Object other$cart = other.getCart();
        if (this$cart == null ? other$cart != null : !this$cart.equals(other$cart)) return false;
        final Object this$product = this.getProduct();
        final Object other$product = other.getProduct();
        if (this$product == null ? other$product != null : !this$product.equals(other$product)) return false;
        if (this.getQuantity() != other.getQuantity()) return false;
        final Object this$dateCreated = this.getDateCreated();
        final Object other$dateCreated = other.getDateCreated();
        if (this$dateCreated == null ? other$dateCreated != null : !this$dateCreated.equals(other$dateCreated))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CartItem;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $cart = this.getCart();
        result = result * PRIME + ($cart == null ? 43 : $cart.hashCode());
        final Object $product = this.getProduct();
        result = result * PRIME + ($product == null ? 43 : $product.hashCode());
        result = result * PRIME + this.getQuantity();
        final Object $dateCreated = this.getDateCreated();
        result = result * PRIME + ($dateCreated == null ? 43 : $dateCreated.hashCode());
        return result;
    }

    public String toString() {
        return "CartItem(id=" + this.getId() +
                ", cartId=" + this.getCart().getId() +
                ", productId=" + this.getProduct().getId() +
                ", quantity=" + this.getQuantity() +
                ", dateCreated=" + this.getDateCreated() + ")";
    }
}
