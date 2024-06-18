package com.avdo.spring.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cart_item")
@Data
public class CartItem {
}
