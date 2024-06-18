package com.avdo.spring.app.repository;

import com.avdo.spring.app.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
