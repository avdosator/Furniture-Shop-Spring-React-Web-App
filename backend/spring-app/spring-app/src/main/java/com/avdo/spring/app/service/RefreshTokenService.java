package com.avdo.spring.app.service;

import com.avdo.spring.app.service.domain.model.RefreshToken;

public interface RefreshTokenService {

    String createRefreshToken();
    RefreshToken validateToken(String token);
    void deleteToken(String token);
}
