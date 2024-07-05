package com.avdo.spring.app.service;

import com.avdo.spring.app.entity.CartEntity;
import com.avdo.spring.app.entity.UserEntity;
import com.avdo.spring.app.repository.CartRepository;
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

    public CartEntity createCart() {
        UserEntity userEntity = extractUserFromToken();
        User user = userService.findById(id);
        CartEntity cartEntity = new CartEntity();
        cartEntity.setUserEntity(UserEntity.fromUser(user));
        cartEntity.setDateCreated(Date.valueOf(LocalDate.now()));
        return cartRepository.save(cartEntity);
    }

    public CartEntity findByUserId(Long id) {
        return cartRepository.findByUserEntityId(id).orElse(null);
    }

    private UserEntity extractUserFromToken() {
        return (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
