package com.avdo.spring.app.controller;

import com.avdo.spring.app.entity.Cart;
import com.avdo.spring.app.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/carts")
    public ResponseEntity<Cart> createCart() {
        Cart cart = cartService.createCart(10L);
        return ResponseEntity.ok(cart);
    }

}
