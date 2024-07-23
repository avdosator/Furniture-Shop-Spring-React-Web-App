package com.avdo.spring.app.repository.crud;

import com.avdo.spring.app.repository.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudOrderRepository extends JpaRepository<OrderEntity, Long> {
}
