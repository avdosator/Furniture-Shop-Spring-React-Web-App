package com.avdo.spring.app.service;

import com.avdo.spring.app.entity.OrderItemEntity;
import com.avdo.spring.app.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface OrderItemService {

    OrderItemEntity findById(Long id);

    void createOrderItem(OrderItemEntity orderItemEntity);
}
