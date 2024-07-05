package com.avdo.spring.app.repository;

import com.avdo.spring.app.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository {

    Optional<CartEntity> findByUserEntityId(Long userId);
}
