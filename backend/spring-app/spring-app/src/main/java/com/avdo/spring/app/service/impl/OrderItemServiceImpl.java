package com.avdo.spring.app.service.impl;

import com.avdo.spring.app.repository.entity.OrderItemEntity;
import com.avdo.spring.app.repository.OrderItemRepository;
import com.avdo.spring.app.service.OrderItemService;
import com.avdo.spring.app.service.domain.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public OrderItem findById(Long id) {
        return orderItemRepository.findById(id);
    }

    @Override
    public OrderItem createOrderItem(OrderItemEntity orderItemEntity) {
        return orderItemRepository.createOrderItem(orderItemEntity);
    }

}
