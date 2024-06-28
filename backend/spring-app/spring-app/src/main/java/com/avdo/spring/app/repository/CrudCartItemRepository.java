package com.avdo.spring.app.repository;

import com.avdo.spring.app.entity.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CrudCartItemRepository extends JpaRepository<CartItemEntity, Long> {

    @Transactional
    CartItemEntity save(CartItemEntity cartItemEntity);
}
