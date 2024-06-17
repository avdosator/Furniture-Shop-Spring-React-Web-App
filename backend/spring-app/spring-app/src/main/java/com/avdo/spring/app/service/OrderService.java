package com.avdo.spring.app.service;

import com.avdo.spring.app.entity.Order;
import com.avdo.spring.app.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no order with that ID"));
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }
}
