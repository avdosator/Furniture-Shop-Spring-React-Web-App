package com.avdo.spring.app.service.impl;

import com.avdo.spring.app.repository.RefreshTokenRepository;
import com.avdo.spring.app.service.RefreshTokenService;
import com.avdo.spring.app.service.domain.model.RefreshToken;
import com.avdo.spring.app.service.domain.model.User;
import com.avdo.spring.app.utils.UserUtils;

public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshTokenServiceImpl(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }
    @Override
    public String createRefreshToken() {
        User user = UserUtils.getCurrentUser();
        return refreshTokenRepository.createRefreshToken(user.getId());
    }

    @Override
    public RefreshToken validateToken(String token) {
        return refreshTokenRepository.validateToken(token);
    }

    @Override
    public void deleteToken(String token) {
        refreshTokenRepository.deleteToken(token);
    }
}
