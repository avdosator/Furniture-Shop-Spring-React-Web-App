package com.avdo.spring.app.entity;

import com.avdo.spring.app.service.domain.model.CartItem;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "cart_item")
@Data
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

    public CartItem toDomainModel() {
        return CartItem.builder()
                .id(this.id)
                .cart(this.cartEntity.toDomainModel())
                .product(this.product)
                .quantity(this.quantity)
                .build();
    }
}
