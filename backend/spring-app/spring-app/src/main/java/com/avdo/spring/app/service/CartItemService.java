package com.avdo.spring.app.service;

import com.avdo.spring.app.entity.CartItem;
import com.avdo.spring.app.repository.CartItemRepository;
import com.avdo.spring.app.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class CartItemService {

    private final CartItemRepository cartItemRepository;
    private final CartService cartService;
    private final ProductService productService;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository,
                           CartService cartService,
                           ProductService productService) {
        this.cartItemRepository = cartItemRepository;
        this.cartService = cartService;
        this.productService = productService;
    }

    // just to see that relations are set up correctly
    public void createCartItem() {
        CartItem cartItem = new CartItem();
        cartItem.setCart(cartService.findById(1L));
        cartItem.setProduct(productService.findById(3L));
        cartItem.setQuantity(1);
        cartItem.setDateCreated(Date.valueOf(LocalDate.now()));
        cartItemRepository.save(cartItem);
    }
}
