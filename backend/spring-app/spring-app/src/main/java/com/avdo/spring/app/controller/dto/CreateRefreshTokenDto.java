package com.avdo.spring.app.controller.dto;

import com.avdo.spring.app.service.domain.request.CreateRefreshTokenRequest;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateRefreshTokenDto extends CreateRefreshTokenRequest {

    @JsonCreator
    public CreateRefreshTokenDto(@JsonProperty("refreshToken") String refreshToken) {
        super(refreshToken);
    }

    @NotBlank
    @Size(min = 64, max = 64)
    @Override
    public String getRefreshToken() {
        return refreshToken;
    }
}
