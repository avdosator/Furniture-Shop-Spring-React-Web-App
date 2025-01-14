package com.avdo.spring.app.repository.entity;

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

    public String toString() {
        return "CartEntity(id=" + this.getId() +
                ", userEntityId=" + this.getUserEntity().getId() +
                ", dateCreated=" + this.getDateCreated() + ")";
    }
}
