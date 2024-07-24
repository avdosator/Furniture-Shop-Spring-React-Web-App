package com.avdo.spring.app.repository.impl;

import com.avdo.spring.app.repository.entity.CartEntity;
import com.avdo.spring.app.repository.entity.UserEntity;
import com.avdo.spring.app.repository.CartRepository;
import com.avdo.spring.app.repository.crud.CrudCartRepository;
import com.avdo.spring.app.service.domain.model.Cart;
import com.avdo.spring.app.service.domain.model.User;
import com.avdo.spring.app.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
        User user = UserUtils.getCurrentUser();
        CartEntity cartEntity = new CartEntity();
        cartEntity.setUserEntity(UserEntity.fromUser(user));
        cartEntity.setDateCreated(Date.valueOf(LocalDate.now()));
        return crudCartRepository.save(cartEntity).toDomainModel();

    }

}
