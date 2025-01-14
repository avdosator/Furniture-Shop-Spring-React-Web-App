package com.avdo.spring.app.repository.entity;

import com.avdo.spring.app.service.domain.model.Order;
import com.avdo.spring.app.service.domain.model.OrderItem;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "\"order\"")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class OrderEntity {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "orderEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItemEntity> orderItemEntities;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "date_created", updatable = false)
    private Date dateCreated;

    public OrderEntity() {
    }

    public Long getId() { return this.id; }

    public UserEntity getUserEntity() { return this.userEntity; }

    public List<OrderItemEntity> getOrderItems() { return this.orderItemEntities; }

    public double getTotalAmount() { return this.totalAmount; }

    public String getOrderStatus() { return this.orderStatus; }

    public Date getDateCreated() { return this.dateCreated; }

    public void setId(Long id) { this.id = id; }

    public void setUserEntity(UserEntity userEntity) { this.userEntity = userEntity; }

    public void setOrderItems(List<OrderItemEntity> orderItemEntities) { this.orderItemEntities = orderItemEntities; }

    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }

    public void setDateCreated(Date dateCreated) { this.dateCreated = dateCreated; }

    public Order toDomainModel() {
        List<OrderItem> orderItems =
                (this.orderItemEntities == null ? Collections.emptyList() : this.orderItemEntities.stream()
                .map(OrderItemEntity::toDomainModel)
                .toList());
        return Order.builder()
                .id(this.id)
                .user(this.userEntity.toDomainModel())
                .orderItems(orderItems)
                .totalAmount(this.totalAmount)
                .orderStatus(this.orderStatus)
                .dateCreated(this.dateCreated)
                .build();
    }

    public String toString() {
        return "Order(id=" + this.getId() +
                ", userEntityId=" + this.getUserEntity().getId() +
                ", orderItems=" + this.getOrderItems() +
                ", totalAmount=" + this.getTotalAmount() +
                ", orderStatus=" + this.getOrderStatus() +
                ", dateCreated=" + this.getDateCreated() + ")";
    }
}
