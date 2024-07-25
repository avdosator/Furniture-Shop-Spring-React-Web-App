package com.avdo.spring.app.repository.entity;

import com.avdo.spring.app.service.domain.model.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "users")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UserEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "date_created", updatable = false)
    private Date dateCreated;

    @Column(name = "role")
    private String role;

    // should I add this -> cascade = CascadeType.ALL, orphanRemoval = true
    @OneToMany(mappedBy = "userEntity", fetch = FetchType.EAGER)
    private List<OrderEntity> orders;

    public UserEntity() {
    }

    public Long getId() { return this.id; }

    public String getFirstname() { return this.firstname; }

    public String getLastname() { return this.lastname; }

    public String getUsername() { return this.username; }

    public String getEmail() { return this.email; }

    public String getPassword() { return this.password; }

    public Date getDateCreated() { return this.dateCreated; }

    public String getRole() { return this.role; }

    public List<OrderEntity> getOrders() { return this.orders; }

    public void setId(Long id) { this.id = id; }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public void setUsername(String username) { this.username = username; }

    public void setEmail(String email) { this.email = email; }

    public void setPassword(String password) { this.password = password; }

    public void setDateCreated(Date dateCreated) { this.dateCreated = dateCreated; }

    public void setRole(String role) { this.role = role; }

    public void setOrders(List<OrderEntity> orders) { this.orders = orders; }

    public User toDomainModel() {
        return User.builder()
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

    public String toString() {
        return "UserEntity(id=" + this.getId() +
                ", firstname=" + this.getFirstname() +
                ", lastname=" + this.getLastname() +
                ", username=" + this.getUsername() +
                ", email=" + this.getEmail() +
                ", password=" + this.getPassword() +
                ", dateCreated=" + this.getDateCreated() +
                ", role=" + this.getRole() + ")";
    }
}
