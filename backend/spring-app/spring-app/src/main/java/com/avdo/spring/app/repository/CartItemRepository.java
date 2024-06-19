package com.avdo.spring.app.repository;

import com.avdo.spring.app.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    @Transactional
    CartItem save(CartItem cartItem);
}
