package com.avdo.spring.app.controller;

import com.avdo.spring.app.entity.CartEntity;
import com.avdo.spring.app.service.CartService;
import com.avdo.spring.app.service.domain.model.Cart;
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
    public Cart createCart() {
        Cart cart = cartService.createCart();
        return cart;
    }

}
