package com.avdo.spring.app.service;

import com.avdo.spring.app.entity.CartItemEntity;
import com.avdo.spring.app.service.domain.request.CreateCartItemRequest;

import java.util.List;

public interface CartItemService {

    CartItemEntity createCartItem(CreateCartItemRequest createCartItemRequest);
    List<CartItemEntity> findAllCartItems();
}
