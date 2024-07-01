package com.avdo.spring.app.service;

import com.avdo.spring.app.entity.CartItemEntity;
import com.avdo.spring.app.service.domain.model.CartItem;
import com.avdo.spring.app.service.domain.request.CreateCartItemRequest;

import java.util.List;

public interface CartItemService {

    CartItem createCartItem(CreateCartItemRequest createCartItemRequest);
    List<CartItem> findAllCartItems();
}
