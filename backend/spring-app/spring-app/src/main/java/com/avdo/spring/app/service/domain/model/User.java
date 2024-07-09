package com.avdo.spring.app.service.domain.model;

import com.avdo.spring.app.entity.Order;
import lombok.Builder;
import lombok.Getter;

import java.sql.Date;
import java.util.List;

@Getter
@Builder
public class User {

    private final Long id;

    private final String firstname;

    private final String lastname;

    private final String username;

    private final String email;

    private final String password;

    private final Date dateCreated;

    private final String role;

    private final List<Order> orders;


    public String toString() {
        return "User(id=" + this.getId() +
                ", firstname=" + this.getFirstname() +
                ", lastname=" + this.getLastname() +
                ", username=" + this.getUsername() +
                ", email=" + this.getEmail() +
                ", password=" + this.getPassword() +
                ", dateCreated=" + this.getDateCreated() +
                ", role=" + this.getRole() +
                /*", orders=" + this.getOrders() +*/ ")";
    }

}
