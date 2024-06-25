package com.avdo.spring.app.controller;

import com.avdo.spring.app.controller.dto.CreateCartItemRequest;
import com.avdo.spring.app.entity.CartItem;
import com.avdo.spring.app.service.CartItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class CartItemController {

    private final CartItemService cartItemService;

    @Autowired
    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping("/cart-items")
    public ResponseEntity<CartItem> createCartItem(@Valid @RequestBody CreateCartItemRequest createCartItemRequest,
                                                BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toList();
            throw new RuntimeException(errors.toString());
        } else {
            try {
                CartItem cartItem = cartItemService.createCartItem(createCartItemRequest);
                return ResponseEntity.ok(cartItem);
            } catch (NoSuchElementException e) {
                throw new RuntimeException("Failed to create cart item " + e.getMessage());
            }
        }
    }

    @GetMapping("/cart-items")
    public ResponseEntity<List<CartItem>> findAllCartItems() {
        List<CartItem> cartItems = cartItemService.findAllCartItems();
        if (cartItems.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(cartItems);
        }
    }

}
