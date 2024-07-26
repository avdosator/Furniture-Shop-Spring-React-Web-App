package com.avdo.spring.app.repository.crud;

import com.avdo.spring.app.repository.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudOrderItemRepository extends JpaRepository<OrderItemEntity, Long> {
}
