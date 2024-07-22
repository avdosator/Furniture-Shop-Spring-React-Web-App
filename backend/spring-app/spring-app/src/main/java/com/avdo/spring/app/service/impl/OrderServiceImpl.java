package com.avdo.spring.app.service.impl;

import com.avdo.spring.app.controller.dto.CreateOrderDto;
import com.avdo.spring.app.entity.*;
import com.avdo.spring.app.repository.OrderRepository;
import com.avdo.spring.app.service.CartService;
import com.avdo.spring.app.service.OrderItemService;
import com.avdo.spring.app.service.OrderService;
import com.avdo.spring.app.service.domain.model.Cart;
import com.avdo.spring.app.service.domain.model.OrderItem;
import com.avdo.spring.app.service.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final OrderItemService orderItemService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, CartService cartService, OrderItemService orderItemService) {

        this.orderRepository = orderRepository;
        this.cartService = cartService;
        this.orderItemService = orderItemService;
    }

    public OrderEntity findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no order with that ID"));
    }

    public List<OrderEntity> findAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    public OrderEntity createOrder(CreateOrderDto createOrderRequest) {
        CustomUserDetails customUserDetails = extractUserFromToken();
        User user = customUserDetails.getUser();
        UserEntity userEntity = UserEntity.fromUser(user);
        CartEntity cartEntity;
        Cart cart = cartService.findByUserId(user.getId());
        if (cart != null) {
            cartEntity = CartEntity.fromCart(cart, userEntity);
            OrderEntity order = createAndSaveOrder(userEntity, cartEntity);
            createAndSaveOrderItems(cartEntity, order);
            return order;
        } else {
            Cart newCart = cartService.createCart(user);
            cartEntity = CartEntity.fromCart(newCart, userEntity);
            OrderEntity order = createAndSaveOrder(userEntity, cartEntity);
            createAndSaveOrderItems(cartEntity, order);
            return order;
        }
    }

    private void createAndSaveOrderItems(CartEntity cartEntity, OrderEntity order) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItemEntity cartItemEntity : cartEntity.getItems()) {
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            orderItemEntity.setOrder(order);
            orderItemEntity.setProductEntity(cartItemEntity.getProductEntity());
            orderItemEntity.setQuantity(cartItemEntity.getQuantity());
            orderItemEntity.setPrice(cartItemEntity.getProductEntity().getPrice());

            OrderItem orderItem = orderItemService.createOrderItem(orderItemEntity);
            orderItems.add(orderItem);
        }
        setOrderItems(orderItems, order);

    }

    private void setOrderItems(List<OrderItem> orderItems, OrderEntity order) {
        List<OrderItemEntity> orderItemEntities = new ArrayList<>();
        for (OrderItem orderItem: orderItems) {
            orderItemEntities.add(OrderItemEntity.fromOrderItem(orderItem));
        }
        order.setOrderItems(orderItemEntities);
    }

    private OrderEntity createAndSaveOrder(UserEntity userEntity, CartEntity cartEntity) {
        OrderEntity order = new OrderEntity();
        order.setUserEntity(userEntity);
        order.setTotalAmount(cartEntity.getItems().stream().mapToDouble(item -> item.getProductEntity().getPrice() * item.getQuantity()).sum());
        order.setOrderStatus("Pending");
        order.setDateCreated(Date.valueOf(LocalDate.now()));

        orderRepository.save(order);
        return order;
    }

    private CustomUserDetails extractUserFromToken() {
        return (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
