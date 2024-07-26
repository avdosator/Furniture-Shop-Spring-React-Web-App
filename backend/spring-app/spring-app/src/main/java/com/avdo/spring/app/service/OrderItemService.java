package com.avdo.spring.app.service;

import com.avdo.spring.app.repository.entity.OrderItemEntity;
import com.avdo.spring.app.service.domain.model.OrderItem;

public interface OrderItemService {

    OrderItem findById(Long id);

    OrderItem createOrderItem(OrderItemEntity orderItemEntity);
}
