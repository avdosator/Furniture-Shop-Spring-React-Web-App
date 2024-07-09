package com.avdo.spring.app.repository.crud;

import com.avdo.spring.app.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CrudCartRepository extends JpaRepository<CartEntity, Long> {

    Optional<CartEntity> findByUserEntityId(Long userId);
}
