package com.avdo.spring.app.repository.impl;

import com.avdo.spring.app.repository.OrderItemRepository;
import com.avdo.spring.app.repository.crud.CrudOrderItemRepository;
import com.avdo.spring.app.repository.entity.OrderItemEntity;
import com.avdo.spring.app.service.domain.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderItemJpaRepository implements OrderItemRepository {

    private final CrudOrderItemRepository crudOrderItemRepository;

    @Autowired
    public OrderItemJpaRepository(CrudOrderItemRepository crudOrderItemRepository) {
        this.crudOrderItemRepository = crudOrderItemRepository;
    }

    @Override
    public OrderItem createOrderItem(OrderItemEntity orderItemEntity) {
        return crudOrderItemRepository.save(orderItemEntity).toDomainModel();
    }

    @Override
    public OrderItem findById(Long id) {
        OrderItemEntity orderItemEntity = crudOrderItemRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no order item with that id"));
        return orderItemEntity.toDomainModel();
    }
}
