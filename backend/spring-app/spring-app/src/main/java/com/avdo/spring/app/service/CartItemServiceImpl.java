package com.avdo.spring.app.service;

import com.avdo.spring.app.repository.CartItemRepository;
import com.avdo.spring.app.service.domain.model.CartItem;
import com.avdo.spring.app.service.domain.request.CreateCartItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public List<CartItem> findAllCartItems() {
        return cartItemRepository.findAllCartItems();
    }

    @Override
    public CartItem createCartItem(CreateCartItemRequest createCartItemRequest) {
        return cartItemRepository.saveCartItem(createCartItemRequest);
    }
}
