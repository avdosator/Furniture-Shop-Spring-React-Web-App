package com.avdo.spring.app.repository;

import com.avdo.spring.app.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
