package com.avdo.spring.app.service;

import com.avdo.spring.app.repository.impl.CartItemRepository;
import com.avdo.spring.app.service.domain.model.CartItem;
import com.avdo.spring.app.service.domain.request.CreateCartItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;
    private final CartService cartService;
    private final ProductService productService;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository,
                               CartService cartService,
                               ProductService productService) {
        this.cartItemRepository = cartItemRepository;
        this.cartService = cartService;
        this.productService = productService;
    }

    public List<CartItem> findAllCartItems() {
        return cartItemRepository.findAllCartItems();
    }

    @Override
    public CartItem createCartItem(CreateCartItemRequest createCartItemRequest) {
        return cartItemRepository.saveCartItem(createCartItemRequest);
    }
}
