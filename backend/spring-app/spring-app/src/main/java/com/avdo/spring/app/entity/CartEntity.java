package com.avdo.spring.app.entity;

import com.avdo.spring.app.service.domain.model.Cart;
import com.avdo.spring.app.service.domain.model.CartItem;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "cart")
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
    private List<CartItemEntity> items = new ArrayList<>();

    @Column(name = "date_created", updatable = false)
    private Date dateCreated;

    public CartEntity() {
    }

    public Cart toDomainModel() {

        List<CartItem> cartItems = (this.items == null ? Collections.emptyList() : this.items.stream()
                .map(CartItemEntity::toDomainModel)
                .collect(Collectors.toList()));

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
        cartEntity.setId(cart.getId());
        cartEntity.setUserEntity(userEntity);

        List<CartItemEntity> cartItemEntities = cart.getCartItems().stream()
                .map(cartItem -> {
                    CartItemEntity cartItemEntity = new CartItemEntity();
                    cartItemEntity.setId(cartItem.getId());
                    cartItemEntity.setCartEntity(cartEntity); // Important to set the back reference
                    cartItemEntity.setProduct(cartItem.getProduct());
                    cartItemEntity.setQuantity(cartItem.getQuantity());
                    cartItemEntity.setDateCreated(cartItem.getDateCreated()); // CartItem needs to have dateCreated field ??
                    return cartItemEntity;
                })
                .toList();
        cartEntity.setItems(cartItemEntities);
        return cartEntity;
    }

    public Long getId() {
        return this.id;
    }

    public UserEntity getUserEntity() {
        return this.userEntity;
    }

    public List<CartItemEntity> getItems() {
        return this.items;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public void setItems(List<CartItemEntity> items) {
        this.items = items;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CartEntity)) return false;
        final CartEntity other = (CartEntity) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$userEntity = this.getUserEntity();
        final Object other$userEntity = other.getUserEntity();
        if (this$userEntity == null ? other$userEntity != null : !this$userEntity.equals(other$userEntity))
            return false;
        final Object this$items = this.getItems();
        final Object other$items = other.getItems();
        if (this$items == null ? other$items != null : !this$items.equals(other$items)) return false;
        final Object this$dateCreated = this.getDateCreated();
        final Object other$dateCreated = other.getDateCreated();
        if (this$dateCreated == null ? other$dateCreated != null : !this$dateCreated.equals(other$dateCreated))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CartEntity;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $userEntity = this.getUserEntity();
        result = result * PRIME + ($userEntity == null ? 43 : $userEntity.hashCode());
        final Object $items = this.getItems();
        result = result * PRIME + ($items == null ? 43 : $items.hashCode());
        final Object $dateCreated = this.getDateCreated();
        result = result * PRIME + ($dateCreated == null ? 43 : $dateCreated.hashCode());
        return result;
    }

    public String toString() {
        return "CartEntity(id=" + this.getId() +
                ", userEntity=" + this.getUserEntity().getId() +
                //", items=" + this.getItems() +
                ", dateCreated=" + this.getDateCreated() + ")";
    }
}
