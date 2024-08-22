package com.avdo.spring.app.service.domain.request;

public class CreateRefreshTokenRequest {

    protected final String refreshToken;

    public CreateRefreshTokenRequest(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }
}

