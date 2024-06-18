package com.avdo.spring.app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "cart_item")
@Data
public class CartItem {

    @Id
    @Column(name = "cart_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Cart cart;

    private Product product;

    private int quantity;

    private Date dateCreated;
}
