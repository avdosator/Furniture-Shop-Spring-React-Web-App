package com.avdo.spring.app.service;

import com.avdo.spring.app.entity.OrderItemEntity;
import com.avdo.spring.app.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public OrderItemEntity findById(Long id) {
        return orderItemRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no order item with that id"));
    }

    public void createOrderItem(OrderItemEntity orderItemEntity) {
        orderItemRepository.save(orderItemEntity);
    }
}
