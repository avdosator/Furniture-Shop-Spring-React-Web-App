package com.avdo.spring.app.repository.crud;

import com.avdo.spring.app.repository.entity.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


public interface CrudCartItemRepository extends JpaRepository<CartItemEntity, Long> {

    @Transactional
    CartItemEntity save(CartItemEntity cartItemEntity);
}
