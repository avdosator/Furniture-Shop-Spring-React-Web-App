package com.avdo.spring.app.entity;

import com.avdo.spring.app.service.domain.model.CartItem;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cart_item")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CartItemEntity {

    @Id
    @Column(name = "cart_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private CartEntity cartEntity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "date_created", updatable = false)
    private Date dateCreated;

    public CartItemEntity() {
    }

    public CartItem toDomainModel() {
        return CartItem.builder()
                .id(this.id)
                .cart(this.cartEntity.toDomainModel())
                .product(this.product)
                .quantity(this.quantity)
                .dateCreated(this.dateCreated)
                .build();
    }

    public Long getId() {
        return this.id;
    }

    public CartEntity getCartEntity() {
        return this.cartEntity;
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

    public void setCartEntity(CartEntity cartEntity) {
        this.cartEntity = cartEntity;
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
        if (!(o instanceof CartItemEntity)) return false;
        final CartItemEntity other = (CartItemEntity) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$cartEntity = this.getCartEntity();
        final Object other$cartEntity = other.getCartEntity();
        if (this$cartEntity == null ? other$cartEntity != null : !this$cartEntity.equals(other$cartEntity))
            return false;
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
        return other instanceof CartItemEntity;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $cartEntity = this.getCartEntity();
        result = result * PRIME + ($cartEntity == null ? 43 : $cartEntity.hashCode());
        final Object $product = this.getProduct();
        result = result * PRIME + ($product == null ? 43 : $product.hashCode());
        result = result * PRIME + this.getQuantity();
        final Object $dateCreated = this.getDateCreated();
        result = result * PRIME + ($dateCreated == null ? 43 : $dateCreated.hashCode());
        return result;
    }

    public String toString() {
        return "CartItemEntity(id=" + this.getId() +
                ", cartEntityId=" + this.getCartEntity().getId() +
                ", productId=" + this.getProduct().getId() +
                ", quantity=" + this.getQuantity() +
                ", dateCreated=" + this.getDateCreated() + ")";
    }
}
