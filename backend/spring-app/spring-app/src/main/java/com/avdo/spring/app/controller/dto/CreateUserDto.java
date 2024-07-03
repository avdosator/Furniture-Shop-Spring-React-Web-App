package com.avdo.spring.app.controller.dto;

import com.avdo.spring.app.service.domain.request.CreateUserRequest;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

public class CreateUserDto extends CreateUserRequest {

    @JsonCreator
    public CreateUserDto(
            @JsonProperty("firstname") String firstname,
            @JsonProperty("lastname") String lastname,
            @JsonProperty("username") String username,
            @JsonProperty("email") String email,
            @JsonProperty("password") String password
    ) {
        super(firstname, lastname, username, email, password);
    }

    @NotBlank
    @Override
    public String getFirstname() {
        return firstname;
    }

    @NotBlank
    @Override
    public String getLastname() {
        return lastname;
    }

    @NotBlank
    @Override
    public String getUsername() {
        return username;
    }

    @Email
    @NotBlank
    @Override
    public String getEmail() {
        return email;
    }

    @NotBlank
    @Size(min = 8, max = 20)
    @Override
    public  String getPassword() {
        return password;
    }
}
