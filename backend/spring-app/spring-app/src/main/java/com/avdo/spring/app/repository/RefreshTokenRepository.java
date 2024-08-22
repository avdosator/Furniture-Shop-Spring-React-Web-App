package com.avdo.spring.app.repository;

import com.avdo.spring.app.service.domain.model.RefreshToken;
import com.avdo.spring.app.service.domain.model.User;

public interface RefreshTokenRepository {

    String createRefreshToken(Long userId);
    RefreshToken validateToken(String token);
    void deleteToken(String token);
}
