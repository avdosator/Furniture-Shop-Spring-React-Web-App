package com.avdo.spring.app.service.impl;

import com.avdo.spring.app.entity.CustomUserDetails;
import com.avdo.spring.app.repository.CartItemRepository;
import com.avdo.spring.app.service.CartItemService;
import com.avdo.spring.app.service.CartService;
import com.avdo.spring.app.service.domain.model.Cart;
import com.avdo.spring.app.service.domain.model.CartItem;
import com.avdo.spring.app.service.domain.model.User;
import com.avdo.spring.app.service.domain.request.CreateCartItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
        CustomUserDetails customUserDetails = extractUserFromToken();
        User user = customUserDetails.getUser();

        try {
            Cart cart = cartService.findByUserId(user.getId());
            return cartItemRepository.saveCartItem(createCartItemRequest, cart, user);
        } catch (NoSuchElementException e) {
            Cart cart = cartService.createCart(user);
            return cartItemRepository.saveCartItem(createCartItemRequest, cart, user);
        }
    }

    private CustomUserDetails extractUserFromToken() {
        return (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
