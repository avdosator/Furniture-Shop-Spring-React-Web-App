package com.avdo.spring.app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cart")
@Data
public class Cart {

    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
