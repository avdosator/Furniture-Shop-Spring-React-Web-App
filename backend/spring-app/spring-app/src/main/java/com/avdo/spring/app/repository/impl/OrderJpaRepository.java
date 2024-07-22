package com.avdo.spring.app.repository.impl;

import com.avdo.spring.app.repository.OrderRepository;
import com.avdo.spring.app.repository.crud.CrudOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderJpaRepository implements OrderRepository {

    private final CrudOrderRepository crudOrderRepository;

    @Autowired
    public OrderJpaRepository(CrudOrderRepository crudOrderRepository) {
        this.crudOrderRepository = crudOrderRepository;
    }
}
