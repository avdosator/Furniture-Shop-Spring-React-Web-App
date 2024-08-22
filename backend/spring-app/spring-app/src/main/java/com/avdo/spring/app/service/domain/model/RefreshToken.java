package com.avdo.spring.app.service.domain.model;

import java.time.LocalDateTime;

public class RefreshToken {

    private Long id;
    private String tokenHash;
    private User user;
    private LocalDateTime expiryDate;
    private LocalDateTime createdAt;

    public RefreshToken(Long id, String tokenHash, User user, LocalDateTime expiryDate, LocalDateTime createdAt) {
        this.id = id;
        this.tokenHash = tokenHash;
        this.user = user;
        this.expiryDate = expiryDate;
        this.createdAt = createdAt;
    }

    public static RefreshTokenBuilder builder() {
        return new RefreshTokenBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getTokenHash() {
        return this.tokenHash;
    }

    public User getUser() {
        return this.user;
    }

    public LocalDateTime getExpiryDate() {
        return this.expiryDate;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTokenHash(String tokenHash) {
        this.tokenHash = tokenHash;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public static class RefreshTokenBuilder {
        private Long id;
        private String tokenHash;
        private User user;
        private LocalDateTime expiryDate;
        private LocalDateTime createdAt;

        RefreshTokenBuilder() {
        }

        public RefreshTokenBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public RefreshTokenBuilder tokenHash(String tokenHash) {
            this.tokenHash = tokenHash;
            return this;
        }

        public RefreshTokenBuilder user(User user) {
            this.user = user;
            return this;
        }

        public RefreshTokenBuilder expiryDate(LocalDateTime expiryDate) {
            this.expiryDate = expiryDate;
            return this;
        }

        public RefreshTokenBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public RefreshToken build() {
            return new RefreshToken(this.id, this.tokenHash, this.user, this.expiryDate, this.createdAt);
        }

        public String toString() {
            return "RefreshToken(id=" + this.id + ", " +
                    "tokenHash=" + this.tokenHash + ", " +
                    "user=" + this.user + ", " +
                    "expiryDate=" + this.expiryDate + ", " +
                    "createdAt=" + this.createdAt + ")";
        }
    }
}
