package com.avdo.spring.app.service.domain.model;

import com.avdo.spring.app.entity.CartItemEntity;
import com.avdo.spring.app.entity.UserEntity;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Builder
@Data
public class Cart {

    private Long id;

    private UserEntity userEntity;

    private List<CartItemEntity> items;

    private Date dateCreated;
}
