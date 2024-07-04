package com.avdo.spring.app.service;

import com.avdo.spring.app.entity.Cart;
import com.avdo.spring.app.entity.UserEntity;
import com.avdo.spring.app.repository.CartRepository;
import com.avdo.spring.app.service.domain.model.User;
import com.avdo.spring.app.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final UserServiceImpl userService;

    @Autowired
    public CartService(CartRepository cartRepository, UserServiceImpl userService) {
        this.cartRepository = cartRepository;
        this.userService = userService;
    }

    public Cart createCart(Long id) {
        User user = userService.findById(id);
        Cart cart = new Cart();
        cart.setUserEntity(UserEntity.fromUser(user));
        cart.setDateCreated(Date.valueOf(LocalDate.now()));
        return cartRepository.save(cart);
    }

    public Cart findByUserId(Long id) {
        return cartRepository.findByUserEntityId(id).orElse(null);
    }
}
