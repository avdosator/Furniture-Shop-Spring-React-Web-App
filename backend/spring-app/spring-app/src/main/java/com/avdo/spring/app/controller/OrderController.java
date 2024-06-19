package com.avdo.spring.app.controller;

import com.avdo.spring.app.dto.CreateOrderRequest;
import com.avdo.spring.app.entity.Order;
import com.avdo.spring.app.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/database")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@Valid @RequestBody CreateOrderRequest createOrderRequest) {
        Order order = orderService.createOrder(createOrderRequest);
        return ResponseEntity.ok(order);
    }
}
