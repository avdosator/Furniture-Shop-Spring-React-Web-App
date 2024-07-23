package com.avdo.spring.app.service.domain.request;

public class CreateUserRequest {

    protected final String firstname;
    protected final String lastname;
    protected final String username;
    protected final String email;
    protected final String password;

    public CreateUserRequest(String firstname, String lastname, String username, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
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
}
