package com.avdo.spring.app.controller;

import com.avdo.spring.app.controller.dto.CreateOrderDto;
import com.avdo.spring.app.entity.OrderEntity;
import com.avdo.spring.app.service.OrderService;
import com.avdo.spring.app.service.domain.model.Order;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public Order createOrder(@Valid @RequestBody CreateOrderDto createOrderDto) {
        return orderService.createOrder(createOrderDto);
    }

}
