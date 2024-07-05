package com.avdo.spring.app.service;

import com.avdo.spring.app.entity.CartEntity;
import com.avdo.spring.app.entity.UserEntity;
import com.avdo.spring.app.repository.CartRepository;
import com.avdo.spring.app.service.domain.model.Cart;
import com.avdo.spring.app.service.domain.model.User;
import com.avdo.spring.app.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final UserService userService;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, UserServiceImpl userService) {
        this.cartRepository = cartRepository;
        this.userService = userService;
    }

    public Cart createCart() {
        return cartRepository.createCart();
    }

    public Cart findByUserId(Long id) {
        return cartRepository.findByUserEntityId(id);
    }

}
