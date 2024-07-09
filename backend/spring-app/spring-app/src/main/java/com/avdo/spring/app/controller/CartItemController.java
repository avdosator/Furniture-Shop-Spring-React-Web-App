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
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toList();
            throw new RuntimeException(errors.toString());
        }
        return cartItemService.createCartItem(createCartItemDto);
    }

    @GetMapping("/cart-items")
    public List<CartItem> findAllCartItems() {
        return cartItemService.findAllCartItems();
    }

}
