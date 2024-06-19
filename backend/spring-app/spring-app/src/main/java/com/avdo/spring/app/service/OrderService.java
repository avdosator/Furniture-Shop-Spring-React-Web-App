package com.avdo.spring.app.service;

import com.avdo.spring.app.dto.CreateOrderRequest;
import com.avdo.spring.app.entity.Cart;
import com.avdo.spring.app.entity.Order;
import com.avdo.spring.app.entity.User;
import com.avdo.spring.app.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CartService cartService;

    @Autowired
    public OrderService(OrderRepository orderRepository, CartService cartService) {

        this.orderRepository = orderRepository;
        this.cartService = cartService;
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no order with that ID"));
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public Order createOrder(CreateOrderRequest createOrderRequest) {
        User user = extractUserFromToken();
        Cart cart = cartService.findByUserId(user.getId());
        Order order = new Order();
    }

    private User extractUserFromToken() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
