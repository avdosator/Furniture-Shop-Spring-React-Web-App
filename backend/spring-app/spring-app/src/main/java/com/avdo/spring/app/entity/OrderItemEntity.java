package com.avdo.spring.app.entity;


import com.avdo.spring.app.service.domain.model.OrderItem;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_item")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Getter
@Setter
public class OrderItemEntity {

    @Id
    @Column(name = "order_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    public OrderItemEntity() {
    }

    public OrderItem toDomainModel() {
        return OrderItem.builder()
                .id(this.id)
                .order(this.order)
                .quantity(this.quantity)
                .price(this.price)
                .product(this.productEntity.toDomainModel())
                .build();
    }

    public static OrderItemEntity fromOrderItem(OrderItem orderItem) {
        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setId(orderItem.getId());
        orderItemEntity.setOrder(orderItem.getOrder());
        orderItemEntity.setQuantity(orderItem.getQuantity());
        orderItemEntity.setPrice(orderItem.getPrice());
        orderItemEntity.setProductEntity(ProductEntity.fromProduct(orderItem.getProduct()));
        return orderItemEntity;
    }

    public String toString() {
        return "OrderItem(id=" + this.getId() +
                ", orderId=" + this.getOrder().getId() +
                ", quantity=" + this.getQuantity() +
                ", price=" + this.getPrice() +
                ", productId=" + this.getProductEntity().getId() + ")";
    }
}
