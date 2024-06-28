package com.avdo.spring.app.controller;

import com.avdo.spring.app.controller.dto.CreateCartItemDto;
import com.avdo.spring.app.entity.CartItemEntity;
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
    public ResponseEntity<CartItemEntity> createCartItem(@Valid @RequestBody CreateCartItemDto createCartItemDto,
                                                         BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toList();
            throw new RuntimeException(errors.toString());
        } else {
            try {
                CartItemEntity cartItemEntity = cartItemService.createCartItem(createCartItemDto);
                return ResponseEntity.ok(cartItemEntity);
            } catch (NoSuchElementException e) {
                throw new RuntimeException("Failed to create cart item " + e.getMessage());
            }
        }
    }

    @GetMapping("/cart-items")
    public ResponseEntity<List<CartItemEntity>> findAllCartItems() {
        List<CartItemEntity> cartItemEntities = cartItemService.findAllCartItems();
        if (cartItemEntities.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(cartItemEntities);
        }
    }

}
