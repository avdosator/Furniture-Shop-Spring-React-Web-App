package com.avdo.spring.app.controller.dto;

import com.avdo.spring.app.service.domain.request.LoginUserRequest;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginUserDto extends LoginUserRequest {

    @JsonCreator
    public LoginUserDto(@JsonProperty("username") String username, @JsonProperty("password") String password) {
        super(username, password);
    }

    @NotBlank
    @Override
    public String getUsername() {
        return username;
    }

    @NotBlank
    @Size(min = 8, max = 20)
    @Override
    public String getPassword() {
        return password;
    }

}
