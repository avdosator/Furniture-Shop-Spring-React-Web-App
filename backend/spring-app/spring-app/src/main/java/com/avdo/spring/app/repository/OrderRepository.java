package com.avdo.spring.app.repository;

import com.avdo.spring.app.service.domain.model.Order;
import com.avdo.spring.app.service.domain.model.User;
import com.avdo.spring.app.service.domain.request.CreateOrderRequest;

import java.util.List;

public interface OrderRepository {

    Order findById(Long id);
    List<Order> findAllOrders();
    Order createOrder(CreateOrderRequest createOrderRequest);
}
