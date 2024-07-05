package com.avdo.spring.app.repository.crud;

import com.avdo.spring.app.service.domain.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudCartRepository extends JpaRepository<Cart, Long> {
}
