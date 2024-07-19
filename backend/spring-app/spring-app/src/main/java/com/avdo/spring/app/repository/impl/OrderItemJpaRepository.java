package com.avdo.spring.app.repository.impl;

import com.avdo.spring.app.entity.OrderItemEntity;
import com.avdo.spring.app.repository.OrderItemRepository;
import com.avdo.spring.app.repository.crud.CrudOrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderItemJpaRepository implements OrderItemRepository {

    private final CrudOrderItemRepository crudOrderItemRepository;

    @Autowired
    public OrderItemJpaRepository(CrudOrderItemRepository crudOrderItemRepository) {
        this.crudOrderItemRepository = crudOrderItemRepository;
    }

    public OrderItemEntity findById(Long id) {
        return crudOrderItemRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no order item with that id"));
    }
}
