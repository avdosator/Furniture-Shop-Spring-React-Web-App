package com.avdo.spring.app.controller;

public class LoginResponse {

    private String token;
    private long expiresIn;

    public String getToken() {
        return this.token;
    }

    public long getExpiresIn() {
        return this.expiresIn;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }
}
