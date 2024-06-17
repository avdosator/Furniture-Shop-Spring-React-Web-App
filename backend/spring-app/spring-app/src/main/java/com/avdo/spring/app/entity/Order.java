package com.avdo.spring.app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "order")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "date_created")
    private Date dateCreated;


}
