package com.avdo.spring.app.repository;

import com.avdo.spring.app.repository.entity.OrderItemEntity;
import com.avdo.spring.app.service.domain.model.OrderItem;

public interface OrderItemRepository {

    OrderItem createOrderItem(OrderItemEntity orderItemEntity);
    OrderItem findById(Long id);
}
