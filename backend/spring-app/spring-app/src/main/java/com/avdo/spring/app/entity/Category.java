package com.avdo.spring.app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity()
@Table(name = "category")
@Data
public class Category {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String name;
}
