package com.avdo.spring.app.service;

import com.avdo.spring.app.entity.OrderItem;
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

    public OrderItem findById(Long id) {
        return orderItemRepository.findById(id).orElseThrow();
    }
}
