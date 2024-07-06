package com.avdo.spring.app.entity;

import com.avdo.spring.app.service.domain.model.Cart;
import com.avdo.spring.app.service.domain.model.CartItem;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "cart")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CartEntity {

    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "cartEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItemEntity> items;

    @Column(name = "date_created", updatable = false)
    private Date dateCreated;

    public Cart toDomainModel() {

        List<CartItem> cartItems = this.items.stream()
                .map(CartItemEntity::toDomainModel)
                .collect(Collectors.toList());

        return Cart.builder()
                .id(this.id)
                .user(this.userEntity.toDomainModel())
                .cartItems(cartItems)
                .dateCreated(this.dateCreated)
                .build();
    }

    // temporary method, delete it at the end!!
    public static CartEntity fromCart(Cart cart, UserEntity userEntity) {
        CartEntity cartEntity = new CartEntity();
        cartEntity.setId(cartEntity.getId());
        cartEntity.setUserEntity(userEntity);

        List<CartItemEntity> cartItemEntities = cart.getCartItems().stream()
                .map(cartItem -> {
                    CartItemEntity cartItemEntity = new CartItemEntity();
                    cartItemEntity.setId(cartItem.getId());
                    cartItemEntity.setCartEntity(cartEntity); // Important to set the back reference
                    cartItemEntity.setProduct(cartItem.getProduct());
                    cartItemEntity.setQuantity(cartItem.getQuantity());
                    cartItemEntity.setDateCreated(cartItem.getCart().getDateCreated()); // CartItem needs to have dateCreated field ??
                    return cartItemEntity;
                })
                .toList();
        cartEntity.setItems(cartItemEntities);
        return cartEntity;
    }
}
