package com.avdo.spring.app.repository.impl;

import com.avdo.spring.app.entity.CartItemEntity;
import com.avdo.spring.app.repository.CrudCartItemRepository;
import com.avdo.spring.app.service.domain.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;

public class CartItemJpaRepository implements CartItemRepository {

    @Autowired
    private final CrudCartItemRepository cartItemRepository;

    public CartItemJpaRepository(CrudCartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public CartItem saveCartItem(CartItemEntity cartItemEntity) {
        CartItemEntity savedEntity =  cartItemRepository.save(cartItemEntity);
        return savedEntity.toDomainModel();
    }
}
