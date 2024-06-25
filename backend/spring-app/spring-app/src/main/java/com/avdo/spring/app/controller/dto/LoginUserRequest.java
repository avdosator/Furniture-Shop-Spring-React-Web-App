package com.avdo.spring.app.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginUserRequest {

    @NotBlank
    private String username;

    @NotBlank
    @Size(min = 8, max = 20)
    private String password;
    
}
