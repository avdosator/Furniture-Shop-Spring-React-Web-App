package com.avdo.spring.app.repository.impl;

import com.avdo.spring.app.repository.crud.CrudCartRepository;
import com.avdo.spring.app.repository.crud.CrudOrderItemRepository;
import com.avdo.spring.app.repository.crud.CrudUserRepository;
import com.avdo.spring.app.repository.entity.*;
import com.avdo.spring.app.repository.CartRepository;
import com.avdo.spring.app.repository.OrderItemRepository;
import com.avdo.spring.app.repository.OrderRepository;
import com.avdo.spring.app.repository.crud.CrudOrderRepository;
import com.avdo.spring.app.service.domain.model.Cart;
import com.avdo.spring.app.service.domain.model.Order;
import com.avdo.spring.app.service.domain.model.OrderItem;
import com.avdo.spring.app.service.domain.model.User;
import com.avdo.spring.app.service.domain.request.CreateOrderRequest;
import com.avdo.spring.app.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderJpaRepository implements OrderRepository {

    private final CrudOrderRepository crudOrderRepository;
    private final CrudCartRepository crudCartRepository;
    private final CrudOrderItemRepository crudOrderItemRepository;
    private final CrudUserRepository crudUserRepository;

    @Autowired
    public OrderJpaRepository(CrudOrderRepository crudOrderRepository,
                              CrudCartRepository crudCartRepository,
                              CrudOrderItemRepository crudOrderItemRepository,
                              CrudUserRepository crudUserRepository) {
        this.crudOrderRepository = crudOrderRepository;
        this.crudCartRepository = crudCartRepository;
        this.crudOrderItemRepository = crudOrderItemRepository;
        this.crudUserRepository = crudUserRepository;
    }

    @Override
    public Order findById(Long id) {
        OrderEntity orderEntity = crudOrderRepository.findById(id).orElseThrow(
                () -> new RuntimeException("There is no order with that ID"));
        return orderEntity.toDomainModel();
    }

    @Override
    public List<Order> findAllOrders() {
        List<OrderEntity> orderEntities = crudOrderRepository.findAll();
        List<Order> orders = new ArrayList<>();
        for (OrderEntity orderEntity : orderEntities) {
            orders.add(orderEntity.toDomainModel());
        }
        return orders;
    }

    @Override
    @Transactional
    public Order createOrder(CreateOrderRequest createOrderRequest) {
        User user = UserUtils.getCurrentUser();
        UserEntity userEntity = crudUserRepository.findById(user.getId()).orElseThrow();
        CartEntity cartEntity = crudCartRepository.findByUserEntityId(userEntity.getId()).orElseThrow();

        OrderEntity orderEntity = createAndSaveOrder(userEntity, cartEntity);
        return orderEntity.toDomainModel();
    }

    private List<OrderItemEntity> createAndSaveOrderItems(OrderEntity orderEntity, CartEntity cartEntity) {
        List<OrderItemEntity> orderItemEntities = new ArrayList<>();
        for (CartItemEntity cartItemEntity : cartEntity.getItems()) {
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            orderItemEntity.setOrderEntity(orderEntity);
            orderItemEntity.setProductEntity(cartItemEntity.getProductEntity());
            orderItemEntity.setQuantity(cartItemEntity.getQuantity());
            orderItemEntity.setPrice(cartItemEntity.getProductEntity().getPrice());

            OrderItemEntity savedOrderItemEntity = crudOrderItemRepository.save(orderItemEntity);
            orderItemEntities.add(savedOrderItemEntity);
        }
        return orderItemEntities;
    }

    private OrderEntity createAndSaveOrder(UserEntity userEntity, CartEntity cartEntity) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUserEntity(userEntity);
        orderEntity.setTotalAmount(cartEntity.getItems().stream().mapToDouble(item -> item.getProductEntity().getPrice() * item.getQuantity()).sum());
        orderEntity.setOrderStatus("Pending");
        orderEntity.setDateCreated(Date.valueOf(LocalDate.now()));
        List<OrderItemEntity> orderItemEntities = createAndSaveOrderItems(orderEntity, cartEntity);
        orderEntity.setOrderItems(orderItemEntities);

        crudOrderRepository.save(orderEntity);
        return orderEntity;
    }
}
