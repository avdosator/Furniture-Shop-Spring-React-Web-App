package com.avdo.spring.app.service.domain.model;

import com.avdo.spring.app.entity.Order;
import com.avdo.spring.app.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Builder
@Data
public class User {

    private Long id;

    private String firstname;

    private String lastname;

    private String username;

    private String email;

    private String password;

    private Date dateCreated;

    private String role;

    private List<Order> orders;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .id(this.id)
                .firstname(this.firstname)
                .lastname(this.lastname)
                .username(this.username)
                .email(this.email)
                .password(this.password)
                .dateCreated(this.dateCreated)
                .role(this.role)
                .orders(this.orders)
                .build();
    }
}
