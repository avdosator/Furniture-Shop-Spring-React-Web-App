package com.avdo.spring.app.service.impl;

import com.avdo.spring.app.repository.CartRepository;
import com.avdo.spring.app.service.CartService;
import com.avdo.spring.app.service.domain.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart createCart() {
        return cartRepository.createOrFindCart();
    }

    @Override
    public Cart findByUserId(Long id) {
        return cartRepository.findByUserEntityId(id);
    }

}
