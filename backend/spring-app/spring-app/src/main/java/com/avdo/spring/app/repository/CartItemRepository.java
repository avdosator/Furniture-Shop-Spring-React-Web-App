package com.avdo.spring.app.repository;

import com.avdo.spring.app.service.domain.model.CartItem;
import com.avdo.spring.app.service.domain.request.CreateCartItemRequest;

import java.util.List;

public interface CartItemRepository {

    CartItem saveCartItem(CreateCartItemRequest createCartItemRequest);
    List<CartItem> findAllCartItems();
}