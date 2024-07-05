package com.avdo.spring.app.service;

import com.avdo.spring.app.controller.dto.CreateOrderRequest;
import com.avdo.spring.app.entity.*;
import com.avdo.spring.app.repository.OrderRepository;
import com.avdo.spring.app.service.domain.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final OrderItemService orderItemService;

    @Autowired
    public OrderService(OrderRepository orderRepository, CartService cartService, OrderItemService orderItemService) {

        this.orderRepository = orderRepository;
        this.cartService = cartService;
        this.orderItemService = orderItemService;
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no order with that ID"));
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    public Order createOrder(CreateOrderRequest createOrderRequest) {
        UserEntity userEntity = extractUserFromToken();
        CartEntity cartEntity;
        Cart cart = cartService.findByUserId(userEntity.getId());
        if (cart != null) {
            cartEntity = CartEntity.fromCart(cart, userEntity);
            Order order = createAndSaveOrder(userEntity, cartEntity);
            createAndSaveOrderItems(cartEntity, order);
            return order;
        } else {
            Cart newCart = cartService.createCart();
            cartEntity = CartEntity.fromCart(newCart, userEntity);
            Order order = createAndSaveOrder(userEntity, cartEntity);
            createAndSaveOrderItems(cartEntity, order);
            return order;
        }
    }

    private void createAndSaveOrderItems(CartEntity cartEntity, Order order) {
        for (CartItemEntity cartItemEntity : cartEntity.getItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(cartItemEntity.getProduct());
            orderItem.setQuantity(cartItemEntity.getQuantity());
            orderItem.setPrice(cartItemEntity.getProduct().getPrice());

            orderItemService.createOrderItem(orderItem);
        }
    }

    private Order createAndSaveOrder(UserEntity userEntity, CartEntity cartEntity) {
        Order order = new Order();
        order.setUserEntity(userEntity);
        order.setTotalAmount(cartEntity.getItems().stream().mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity()).sum());
        order.setOrderStatus("Pending");
        order.setDateCreated(Date.valueOf(LocalDate.now()));

        orderRepository.save(order);
        return order;
    }

    private UserEntity extractUserFromToken() {
        return (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
