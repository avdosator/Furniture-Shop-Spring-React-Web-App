package com.avdo.spring.app.service.domain.model;

import com.avdo.spring.app.repository.entity.OrderEntity;

import java.sql.Date;
import java.util.List;

public class User {

    private final Long id;
    private final String firstname;
    private final String lastname;
    private final String username;
    private final String email;
    private final String password;
    private final Date dateCreated;
    private final String role;
    private final List<OrderEntity> orders;

    User(Long id, String firstname, String lastname, String username, String email, String password, Date dateCreated, String role, List<OrderEntity> orders) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.dateCreated = dateCreated;
        this.role = role;
        this.orders = orders;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public String getRole() {
        return this.role;
    }

    public List<OrderEntity> getOrders() {
        return this.orders;
    }

    public static class UserBuilder {
        private Long id;
        private String firstname;
        private String lastname;
        private String username;
        private String email;
        private String password;
        private Date dateCreated;
        private String role;
        private List<OrderEntity> orders;

        UserBuilder() {
        }

        public UserBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public UserBuilder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder dateCreated(Date dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public UserBuilder role(String role) {
            this.role = role;
            return this;
        }

        public UserBuilder orders(List<OrderEntity> orders) {
            this.orders = orders;
            return this;
        }

        public User build() {
            return new User(this.id, this.firstname, this.lastname, this.username, this.email, this.password, this.dateCreated, this.role, this.orders);
        }
    }

    public String toString() {
        return "User(id=" + this.getId() +
                ", firstname=" + this.getFirstname() +
                ", lastname=" + this.getLastname() +
                ", username=" + this.getUsername() +
                ", email=" + this.getEmail() +
                ", password=" + this.getPassword() +
                ", dateCreated=" + this.getDateCreated() +
                ", role=" + this.getRole() + ")";
    }
}
