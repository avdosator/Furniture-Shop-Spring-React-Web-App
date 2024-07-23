package com.avdo.spring.app.repository.impl;

import com.avdo.spring.app.entity.*;
import com.avdo.spring.app.repository.CartRepository;
import com.avdo.spring.app.repository.OrderItemRepository;
import com.avdo.spring.app.repository.OrderRepository;
import com.avdo.spring.app.repository.crud.CrudOrderRepository;
import com.avdo.spring.app.repository.entity.*;
import com.avdo.spring.app.service.domain.model.Cart;
import com.avdo.spring.app.service.domain.model.Order;
import com.avdo.spring.app.service.domain.model.OrderItem;
import com.avdo.spring.app.service.domain.model.User;
import com.avdo.spring.app.service.domain.request.CreateOrderRequest;
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
    private final CartRepository cartRepository;
    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderJpaRepository(CrudOrderRepository crudOrderRepository,
                              CartRepository cartRepository,
                              OrderItemRepository orderItemRepository) {
        this.crudOrderRepository = crudOrderRepository;
        this.cartRepository = cartRepository;
        this.orderItemRepository = orderItemRepository;
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
    public Order createOrder(CreateOrderRequest createOrderRequest, User user) {
        UserEntity userEntity = UserEntity.fromUser(user);
        CartEntity cartEntity;
        Cart cart = cartRepository.findByUserEntityId(user.getId());
        if (cart != null) {
            cartEntity = CartEntity.fromCart(cart, userEntity);
            OrderEntity orderEntity = createAndSaveOrder(userEntity, cartEntity);
            createAndSaveOrderItems(cartEntity, orderEntity);
            return orderEntity.toDomainModel();
        } else {
            Cart newCart = cartRepository.createCart(user);
            cartEntity = CartEntity.fromCart(newCart, userEntity);
            OrderEntity orderEntity = createAndSaveOrder(userEntity, cartEntity);
            createAndSaveOrderItems(cartEntity, orderEntity);
            return orderEntity.toDomainModel();
        }
    }

    private void createAndSaveOrderItems(CartEntity cartEntity, OrderEntity orderEntity) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItemEntity cartItemEntity : cartEntity.getItems()) {
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            orderItemEntity.setOrderEntity(orderEntity);
            orderItemEntity.setProductEntity(cartItemEntity.getProductEntity());
            orderItemEntity.setQuantity(cartItemEntity.getQuantity());
            orderItemEntity.setPrice(cartItemEntity.getProductEntity().getPrice());

            OrderItem orderItem = orderItemRepository.createOrderItem(orderItemEntity);
            orderItems.add(orderItem);
        }
        setOrderItems(orderItems, orderEntity);

    }

    private void setOrderItems(List<OrderItem> orderItems, OrderEntity order) {
        List<OrderItemEntity> orderItemEntities = new ArrayList<>();
        for (OrderItem orderItem : orderItems) {
            //orderItemEntities.add(OrderItemEntity.fromOrderItem(orderItem));
        }
        order.setOrderItems(orderItemEntities);
    }

    private OrderEntity createAndSaveOrder(UserEntity userEntity, CartEntity cartEntity) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUserEntity(userEntity);
        orderEntity.setTotalAmount(cartEntity.getItems().stream().mapToDouble(item -> item.getProductEntity().getPrice() * item.getQuantity()).sum());
        orderEntity.setOrderStatus("Pending");
        orderEntity.setDateCreated(Date.valueOf(LocalDate.now()));

        crudOrderRepository.save(orderEntity);
        return orderEntity;
    }
}
