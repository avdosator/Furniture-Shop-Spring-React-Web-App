package com.avdo.spring.app.repository.entity;

import com.avdo.spring.app.service.domain.model.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Setter
@Getter
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

    // this method will be deleted!!
    public static UserEntity fromUser(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setFirstname(user.getFirstname());
        userEntity.setLastname(user.getLastname());
        userEntity.setUsername(user.getUsername());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setDateCreated(user.getDateCreated());
        userEntity.setRole(user.getRole());
        userEntity.setOrders(user.getOrders());
        return userEntity;
    }

    public String toString() {
        return "UserEntity(id=" + this.getId() +
                ", firstname=" + this.getFirstname() +
                ", lastname=" + this.getLastname() +
                ", username=" + this.getUsername() +
                ", email=" + this.getEmail() +
                ", password=" + this.getPassword() +
                ", dateCreated=" + this.getDateCreated() +
                ", role=" + this.getRole()  + ")";
    }
}
