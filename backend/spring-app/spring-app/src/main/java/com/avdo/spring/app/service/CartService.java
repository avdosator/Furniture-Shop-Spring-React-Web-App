package com.avdo.spring.app.service;

import com.avdo.spring.app.entity.CartEntity;

public interface CartService {

    CartEntity createCart();
    CartEntity findByUserId(Long id);
}
