package com.avdo.spring.app.repository;

import com.avdo.spring.app.service.domain.model.Cart;
import com.avdo.spring.app.service.domain.model.User;

public interface CartRepository {

    Cart findByUserEntityId(Long userId);
    Cart createCart();
}
