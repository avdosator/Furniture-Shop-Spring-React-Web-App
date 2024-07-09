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
                .cartId(this.cartEntity.getId())
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

    public String toString() {
        return "CartItemEntity(id=" + this.getId() +
                ", cartEntityId=" + this.getCartEntity().getId() +
                ", productId=" + this.getProduct().getId() +
                ", quantity=" + this.getQuantity() +
                ", dateCreated=" + this.getDateCreated() + ")";
    }
}
