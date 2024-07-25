package com.avdo.spring.app.repository.entity;


import com.avdo.spring.app.service.domain.model.OrderItem;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@Entity
@Table(name = "order_item")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class OrderItemEntity {

    @Id
    @Column(name = "order_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    public OrderItemEntity() {
    }

    public Long getId() { return this.id; }

    public OrderEntity getOrderEntity() { return this.orderEntity; }

    public int getQuantity() { return this.quantity; }

    public double getPrice() { return this.price; }

    public ProductEntity getProductEntity() { return this.productEntity; }

    public void setId(Long id) { this.id = id; }

    public void setOrderEntity(OrderEntity orderEntity) { this.orderEntity = orderEntity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void setPrice(double price) { this.price = price; }

    public void setProductEntity(ProductEntity productEntity) { this.productEntity = productEntity; }

    public OrderItem toDomainModel() {
        return OrderItem.builder()
                .id(this.id)
                .orderId(this.orderEntity.getId())
                .quantity(this.quantity)
                .price(this.price)
                .product(this.productEntity.toDomainModel())
                .build();
    }

    public String toString() {
        return "OrderItem(id=" + this.getId() +
                ", orderId=" + this.getOrderEntity().getId() +
                ", quantity=" + this.getQuantity() +
                ", price=" + this.getPrice() +
                ", productId=" + this.getProductEntity().getId() + ")";
    }
}
