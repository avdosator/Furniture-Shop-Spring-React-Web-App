package com.avdo.spring.app.repository.impl;

import com.avdo.spring.app.repository.CartRepository;
import com.avdo.spring.app.repository.crud.CrudCartRepository;
import com.avdo.spring.app.repository.crud.CrudUserRepository;
import com.avdo.spring.app.repository.entity.CartEntity;
import com.avdo.spring.app.service.domain.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;

@Repository
public class CartJpaRepository implements CartRepository {

    private final CrudCartRepository crudCartRepository;
    private final CrudUserRepository crudUserRepository;

    @Autowired
    public CartJpaRepository(CrudCartRepository cartRepository,
                             CrudUserRepository crudUserRepository) {
        this.crudCartRepository = cartRepository;
        this.crudUserRepository = crudUserRepository;
    }

    @Override
    public Cart findByUserEntityId(Long id) {
        CartEntity cartEntity = crudCartRepository.findByUserEntityId(id).orElseThrow();
        return cartEntity.toDomainModel();
    }

    @Override
    public Cart createCart(Long userId) {
        CartEntity cartEntity = new CartEntity();
        cartEntity.setUserEntity(crudUserRepository.findById(userId).orElseThrow());
        cartEntity.setDateCreated(Date.valueOf(LocalDate.now()));
        return crudCartRepository.save(cartEntity).toDomainModel();

    }

}
