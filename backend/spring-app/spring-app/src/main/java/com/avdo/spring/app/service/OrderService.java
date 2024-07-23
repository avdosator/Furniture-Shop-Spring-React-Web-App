package com.avdo.spring.app.service;

import com.avdo.spring.app.service.domain.model.Order;
import com.avdo.spring.app.service.domain.request.CreateOrderRequest;

import java.util.List;

public interface OrderService {

    Order findById(Long id);
    List<Order> findAllOrders();
    Order createOrder(CreateOrderRequest createOrderRequest);
}
