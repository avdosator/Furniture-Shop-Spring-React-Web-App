package com.avdo.spring.app.repository.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "refresh_token")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class RefreshToken {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "token_hash", nullable = false, length = 128, unique = true)
    private String tokenHash;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "expiry_date", nullable = false)
    private Date expiryDate;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    public RefreshToken() {
    }

    public Long getId() {
        return this.id;
    }

    public String getTokenHash() {
        return this.tokenHash;
    }

    public UserEntity getUser() {
        return this.user;
    }

    public Date getExpiryDate() {
        return this.expiryDate;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTokenHash(String tokenHash) {
        this.tokenHash = tokenHash;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
