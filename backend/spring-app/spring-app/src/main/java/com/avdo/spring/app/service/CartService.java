package com.avdo.spring.app.service;

import com.avdo.spring.app.entity.Cart;
import com.avdo.spring.app.entity.User;
import com.avdo.spring.app.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final UserService userService;

    @Autowired
    public CartService(CartRepository cartRepository, UserService userService) {
        this.cartRepository = cartRepository;
        this.userService = userService;
    }

    // this will be hardcoded to find user "user"
    public void createCart() {
        User user = userService.findById(10);
        Cart cart = new Cart();
        cart.setUser(user);
        cart.setDateCreated(Date.valueOf(LocalDate.now()));
        cartRepository.save(cart);
    }
}
