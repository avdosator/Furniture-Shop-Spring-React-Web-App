package com.avdo.spring.app.controller;

public class LoginResponse {

    private String accessToken;
    private long expiresIn;
    private String refreshToken;

    public String getAccessToken() {
        return this.accessToken;
    }

    public long getExpiresIn() {
        return this.expiresIn;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}