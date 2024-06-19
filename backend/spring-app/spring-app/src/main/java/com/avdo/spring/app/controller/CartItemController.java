package com.avdo.spring.app.controller;

import com.avdo.spring.app.dto.CreateCartItemRequest;
import com.avdo.spring.app.entity.CartItem;
import com.avdo.spring.app.service.CartItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/database")
public class CartItemController {

    private final CartItemService cartItemService;

    @Autowired
    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping("/create-cart-item")
    public ResponseEntity<String> createCartItem(@Valid @RequestBody CreateCartItemRequest createCartItemRequest,
                                                BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errors.toString());
        } else {
            try {
                cartItemService.createCartItem(createCartItemRequest);
                return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created cart item!");
            } catch (NoSuchElementException e) {
                return ResponseEntity.status((HttpStatus.NOT_FOUND)).body("Failed to create cart item " + e.getMessage());
            }
        }
    }

    // create DTO for response
    @GetMapping("/items")
    public ResponseEntity<List<CartItem>> findAllCartItems() {
        List<CartItem> cartItems = cartItemService.findAllCartItems();
        if (cartItems.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(cartItems);
        }
    }
}
