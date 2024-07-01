package com.avdo.spring.app.repository.impl;

import com.avdo.spring.app.entity.CartItemEntity;
import com.avdo.spring.app.repository.CrudCartItemRepository;
import com.avdo.spring.app.service.domain.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CartItemJpaRepository implements CartItemRepository {

    @Autowired
    private final CrudCartItemRepository cartItemRepository;

    public CartItemJpaRepository(CrudCartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public CartItem saveCartItem(CartItemEntity cartItemEntity) {
        CartItemEntity savedEntity = cartItemRepository.save(cartItemEntity);
        return savedEntity.toDomainModel();
    }

    @Override
    public List<CartItem> findAllCartItems() {
        List<CartItemEntity> cartItemEntities = cartItemRepository.findAll();
        List<CartItem> cartItemModels = new ArrayList<>();
        for (CartItemEntity entity : cartItemEntities) {
            cartItemModels.add(entity.toDomainModel());
        }
        return cartItemModels;
    }
}
