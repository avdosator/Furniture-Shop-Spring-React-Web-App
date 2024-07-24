package com.avdo.spring.app.repository.impl;

import com.avdo.spring.app.repository.crud.CrudProductRepository;
import com.avdo.spring.app.repository.entity.CartEntity;
import com.avdo.spring.app.repository.entity.CartItemEntity;
import com.avdo.spring.app.repository.entity.ProductEntity;
import com.avdo.spring.app.repository.entity.UserEntity;
import com.avdo.spring.app.repository.CartItemRepository;
import com.avdo.spring.app.repository.ProductRepository;
import com.avdo.spring.app.repository.crud.CrudCartItemRepository;
import com.avdo.spring.app.service.domain.model.Cart;
import com.avdo.spring.app.service.domain.model.CartItem;
import com.avdo.spring.app.service.domain.model.User;
import com.avdo.spring.app.service.domain.request.CreateCartItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CartItemJpaRepository implements CartItemRepository {

    private final CrudCartItemRepository crudCartItemRepository;
    private final CrudProductRepository crudProductRepository;

    @Autowired
    public CartItemJpaRepository(CrudCartItemRepository crudCartItemRepository,
                                 CrudProductRepository crudProductRepository) {
        this.crudCartItemRepository = crudCartItemRepository;
        this.crudProductRepository = crudProductRepository;
    }

    @Override
    public CartItem saveCartItem(CreateCartItemRequest createCartItemRequest, Cart cart, User user) {
        UserEntity userEntity = UserEntity.fromUser(user);
        CartItemEntity cartItemEntity = new CartItemEntity();

        cartItemEntity.setCartEntity(CartEntity.fromCart(cart, userEntity));
        cartItemEntity.setProductEntity(crudProductRepository.findById(createCartItemRequest.getProductId()).orElseThrow());
        cartItemEntity.setQuantity(createCartItemRequest.getQuantity());
        cartItemEntity.setDateCreated(Date.valueOf(LocalDate.now()));

        return crudCartItemRepository.save(cartItemEntity).toDomainModel();
    }

    @Override
    public List<CartItem> findAllCartItems() {
        List<CartItemEntity> cartItemEntities = crudCartItemRepository.findAll();
        List<CartItem> cartItemModels = new ArrayList<>();
        for (CartItemEntity entity : cartItemEntities) {
            cartItemModels.add(entity.toDomainModel());
        }
        return cartItemModels;
    }
}
