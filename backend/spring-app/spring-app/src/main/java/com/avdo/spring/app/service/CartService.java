package com.avdo.spring.app.service;

import com.avdo.spring.app.service.domain.model.Cart;

public interface CartService {

    Cart createCart();
    Cart findByUserId(Long id);
}
