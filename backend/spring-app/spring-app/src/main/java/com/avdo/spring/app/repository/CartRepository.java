package com.avdo.spring.app.repository;

import com.avdo.spring.app.service.domain.model.Cart;

public interface CartRepository {

    Cart findByUserEntityId(Long userId);
    Cart createCart(Long userId);
}
