package com.avdo.spring.app.service.domain.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Builder
@Data
public class Cart {

    private Long id;

    private User user;

    private List<CartItem> cartItems;

    private Date dateCreated;
}
