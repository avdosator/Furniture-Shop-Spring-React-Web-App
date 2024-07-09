package com.avdo.spring.app.service.domain.model;

import com.avdo.spring.app.entity.Order;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Setter
@Getter
@Builder
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
