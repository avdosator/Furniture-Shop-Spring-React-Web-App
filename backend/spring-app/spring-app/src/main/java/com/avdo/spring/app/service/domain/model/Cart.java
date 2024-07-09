package com.avdo.spring.app.service.domain.model;

import lombok.Builder;

import java.sql.Date;
import java.util.List;

@Builder
public class Cart {

    private Long id;

    private User user;

    private List<CartItem> cartItems;

    private Date dateCreated;

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Cart)) return false;
        final Cart other = (Cart) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$cartItems = this.getCartItems();
        final Object other$cartItems = other.getCartItems();
        if (this$cartItems == null ? other$cartItems != null : !this$cartItems.equals(other$cartItems)) return false;
        final Object this$dateCreated = this.getDateCreated();
        final Object other$dateCreated = other.getDateCreated();
        if (this$dateCreated == null ? other$dateCreated != null : !this$dateCreated.equals(other$dateCreated))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Cart;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        final Object $cartItems = this.getCartItems();
        result = result * PRIME + ($cartItems == null ? 43 : $cartItems.hashCode());
        final Object $dateCreated = this.getDateCreated();
        result = result * PRIME + ($dateCreated == null ? 43 : $dateCreated.hashCode());
        return result;
    }

    public String toString() {
        return "Cart(id=" + this.getId() +
                ", userId=" + this.getUser().getId() +
                ", cartItems=" + this.getCartItems() +
                ", dateCreated=" + this.getDateCreated() + ")";
    }
}
