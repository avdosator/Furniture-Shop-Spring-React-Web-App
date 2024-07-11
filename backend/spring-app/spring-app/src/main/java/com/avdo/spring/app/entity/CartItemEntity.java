package com.avdo.spring.app.entity;

import com.avdo.spring.app.service.domain.model.CartItem;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "cart_item")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Getter
@Setter
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
    private ProductEntity productEntity;

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
                .product(this.productEntity.toDomainModel())
                .quantity(this.quantity)
                .dateCreated(this.dateCreated)
                .build();
    }

    public String toString() {
        return "CartItemEntity(id=" + this.getId() +
                ", cartEntityId=" + this.getCartEntity().getId() +
                ", productId=" + this.getProductEntity().getId() +
                ", quantity=" + this.getQuantity() +
                ", dateCreated=" + this.getDateCreated() + ")";
    }
}
