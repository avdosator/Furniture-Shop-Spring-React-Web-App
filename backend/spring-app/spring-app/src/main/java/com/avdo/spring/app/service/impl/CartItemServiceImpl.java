package com.avdo.spring.app.service.impl;

import com.avdo.spring.app.repository.CartItemRepository;
import com.avdo.spring.app.service.CartItemService;
import com.avdo.spring.app.service.CartService;
import com.avdo.spring.app.service.domain.model.Cart;
import com.avdo.spring.app.service.domain.model.CartItem;
import com.avdo.spring.app.service.domain.model.User;
import com.avdo.spring.app.service.domain.request.CreateCartItemRequest;
import com.avdo.spring.app.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;
    private final CartService cartService;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository,
                               CartService cartService) {
        this.cartItemRepository = cartItemRepository;
        this.cartService = cartService;
    }

    public List<CartItem> findAllCartItems() {
        return cartItemRepository.findAllCartItems();
    }

    @Override
    public CartItem createCartItem(CreateCartItemRequest createCartItemRequest) {
        User user = UserUtils.getCurrentUser();
        try {
            Cart cart = cartService.findByUserId(user.getId());
            return cartItemRepository.saveCartItem(createCartItemRequest, cart, user.getId());
        } catch (NoSuchElementException e) {
            Cart cart = cartService.createCart();
            return cartItemRepository.saveCartItem(createCartItemRequest, cart, user.getId());
        }
    }
}
