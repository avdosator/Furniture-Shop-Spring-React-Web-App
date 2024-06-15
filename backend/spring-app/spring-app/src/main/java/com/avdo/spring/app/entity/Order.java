package com.avdo.spring.app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "order")
@Data
public class Order {

    // add field for order items like this ??ž
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "date_created")
    private Date dateCreated;


}
