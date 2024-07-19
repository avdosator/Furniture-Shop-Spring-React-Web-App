package com.avdo.spring.app.service.impl;

import com.avdo.spring.app.entity.OrderItemEntity;
import com.avdo.spring.app.repository.OrderItemRepository;
import com.avdo.spring.app.service.OrderItemService;
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
    public OrderItemEntity findById(Long id) {
        return orderItemRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no order item with that id"));
    }

    @Override
    public void createOrderItem(OrderItemEntity orderItemEntity) {
        orderItemRepository.save(orderItemEntity);
    }

}
