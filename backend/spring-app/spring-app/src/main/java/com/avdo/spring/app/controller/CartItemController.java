package com.avdo.spring.app.controller;

import com.avdo.spring.app.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/database")
public class CartItemController {

    private final CartItemService cartItemService;

    @Autowired
    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    // create cart item with some product from database (testing)
    @PostMapping("/create-cart-item")
    public ResponseEntity<String> createCartItem() {
        cartItemService.createCartItem();
        return ResponseEntity.ok("Successfully created cart item");
    }
}
