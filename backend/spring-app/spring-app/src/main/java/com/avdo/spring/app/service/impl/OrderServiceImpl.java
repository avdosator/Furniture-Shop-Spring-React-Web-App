package com.avdo.spring.app.service.impl;

import com.avdo.spring.app.entity.*;
import com.avdo.spring.app.repository.OrderRepository;
import com.avdo.spring.app.service.CartService;
import com.avdo.spring.app.service.OrderItemService;
import com.avdo.spring.app.service.OrderService;
import com.avdo.spring.app.service.domain.model.Order;
import com.avdo.spring.app.service.domain.model.User;
import com.avdo.spring.app.service.domain.request.CreateOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAllOrders();
    }

    @Override
    public Order createOrder(CreateOrderRequest createOrderRequest) {
        CustomUserDetails customUserDetails = extractUserFromToken();
        User user = customUserDetails.getUser();
        Order order = orderRepository.createOrder(createOrderRequest, user);
        return order;
    }

    private CustomUserDetails extractUserFromToken() {
        return (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
