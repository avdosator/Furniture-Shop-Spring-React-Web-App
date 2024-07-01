package com.avdo.spring.app.repository.impl;

import com.avdo.spring.app.entity.CartItemEntity;
import com.avdo.spring.app.service.domain.model.CartItem;
import com.avdo.spring.app.service.domain.request.CreateCartItemRequest;

public interface CartItemRepository {

    CartItem saveCartItem(CartItemEntity cartItemEntity);
}
