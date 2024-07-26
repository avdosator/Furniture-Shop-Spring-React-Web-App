package com.avdo.spring.app.service.domain.request;

public class LoginUserRequest {

    protected final String username;
    protected final String password;

    public LoginUserRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
