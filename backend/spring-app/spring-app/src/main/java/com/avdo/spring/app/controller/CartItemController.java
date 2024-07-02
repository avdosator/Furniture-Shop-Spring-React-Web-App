package com.avdo.spring.app.controller;

import com.avdo.spring.app.controller.dto.CreateCartItemDto;
import com.avdo.spring.app.service.CartItemService;
import com.avdo.spring.app.service.domain.model.CartItem;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
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
    public CartItem createCartItem(@Valid @RequestBody CreateCartItemDto createCartItemDto,
                                                         BindingResult result) {
        System.out.println("Received request to create cart item: " + createCartItemDto);
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toList();
            System.out.println("Validation errors: " + errors);
            throw new RuntimeException(errors.toString());
        } else {
            try {
                System.out.println("Successfully created cart item: ");
                return cartItemService.createCartItem(createCartItemDto);
            } catch (NoSuchElementException e) {
                System.out.println("Failed to create cart item: " + e.getMessage());
                throw new RuntimeException("Failed to create cart item " + e.getMessage());
            }
        }
    }

    @GetMapping("/cart-items")
    public List<CartItem> findAllCartItems() {
        return cartItemService.findAllCartItems();
    }

}
