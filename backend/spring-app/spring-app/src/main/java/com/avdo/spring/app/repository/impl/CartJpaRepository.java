package com.avdo.spring.app.repository.impl;

import com.avdo.spring.app.entity.CartEntity;
import com.avdo.spring.app.entity.UserEntity;
import com.avdo.spring.app.repository.CartRepository;
import com.avdo.spring.app.repository.crud.CrudCartRepository;
import com.avdo.spring.app.service.domain.model.Cart;
import com.avdo.spring.app.service.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;

@Repository
public class CartJpaRepository implements CartRepository {

    private final CrudCartRepository crudCartRepository;

    @Autowired
    public CartJpaRepository(CrudCartRepository cartRepository) {
        this.crudCartRepository = cartRepository;
    }

    @Override
    public Cart findByUserEntityId(Long id) {
        CartEntity cartEntity = crudCartRepository.findByUserEntityId(id).orElseThrow();
        return cartEntity.toDomainModel();
    }

    @Override
    public Cart createCart() {
        UserEntity userEntity = extractUserFromToken();
        CartEntity cartEntity = new CartEntity();
        cartEntity.setUserEntity(userEntity);
        cartEntity.setDateCreated(Date.valueOf(LocalDate.now()));
        return crudCartRepository.save(cartEntity).toDomainModel();
    }

    private UserEntity extractUserFromToken() {
        return (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
