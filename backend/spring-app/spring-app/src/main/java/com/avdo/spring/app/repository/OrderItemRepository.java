package com.avdo.spring.app.repository;

import com.avdo.spring.app.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OrderItemRepository {

    OrderItemEntity findById(Long id);
}
