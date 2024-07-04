package com.avdo.spring.app.entity;

import com.avdo.spring.app.service.domain.model.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "users")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UserEntity implements UserDetails {

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
    private List<Order> orders;

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

    public static UserEntity fromUser(User user) {
        UserEntity userEntity = new UserEntity();
        user.setId(user.getId());
        user.setFirstname(user.getFirstname());
        user.setLastname(user.getLastname());
        user.setUsername(user.getUsername());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        user.setDateCreated(user.getDateCreated());
        user.setRole(user.getRole());
        user.setOrders(user.getOrders());
        return userEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.getRole()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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

    public List<Order> getOrders() {
        return this.orders;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserEntity)) return false;
        final UserEntity other = (UserEntity) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$firstname = this.getFirstname();
        final Object other$firstname = other.getFirstname();
        if (this$firstname == null ? other$firstname != null : !this$firstname.equals(other$firstname)) return false;
        final Object this$lastname = this.getLastname();
        final Object other$lastname = other.getLastname();
        if (this$lastname == null ? other$lastname != null : !this$lastname.equals(other$lastname)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$dateCreated = this.getDateCreated();
        final Object other$dateCreated = other.getDateCreated();
        if (this$dateCreated == null ? other$dateCreated != null : !this$dateCreated.equals(other$dateCreated))
            return false;
        final Object this$role = this.getRole();
        final Object other$role = other.getRole();
        if (this$role == null ? other$role != null : !this$role.equals(other$role)) return false;
        final Object this$orders = this.getOrders();
        final Object other$orders = other.getOrders();
        if (this$orders == null ? other$orders != null : !this$orders.equals(other$orders)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UserEntity;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $firstname = this.getFirstname();
        result = result * PRIME + ($firstname == null ? 43 : $firstname.hashCode());
        final Object $lastname = this.getLastname();
        result = result * PRIME + ($lastname == null ? 43 : $lastname.hashCode());
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $dateCreated = this.getDateCreated();
        result = result * PRIME + ($dateCreated == null ? 43 : $dateCreated.hashCode());
        final Object $role = this.getRole();
        result = result * PRIME + ($role == null ? 43 : $role.hashCode());
        final Object $orders = this.getOrders();
        result = result * PRIME + ($orders == null ? 43 : $orders.hashCode());
        return result;
    }

    public String toString() {
        return "UserEntity(id=" + this.getId() + ", firstname=" + this.getFirstname() + ", lastname=" + this.getLastname() + ", username=" + this.getUsername() + ", email=" + this.getEmail() + ", password=" + this.getPassword() + ", dateCreated=" + this.getDateCreated() + ", role=" + this.getRole() + ", orders=" + this.getOrders() + ")";
    }
}
