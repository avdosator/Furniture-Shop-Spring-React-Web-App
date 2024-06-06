package com.avdo.spring.app.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Data
@Getter
@Setter
public class CreateUserRequest {

    @NotBlank
    private String firstname;

    @NotBlank
    private String lastname;

    @NotBlank
    private String username;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 8, max = 20)
    private String password;


}
