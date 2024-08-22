package com.avdo.spring.app.repository.impl;

import com.avdo.spring.app.repository.RefreshTokenRepository;
import com.avdo.spring.app.repository.crud.CrudRefreshTokenRepository;
import com.avdo.spring.app.repository.crud.CrudUserRepository;
import com.avdo.spring.app.repository.entity.RefreshTokenEntity;
import com.avdo.spring.app.service.domain.model.RefreshToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;

@Repository
public class RefreshTokenJpaRepository implements RefreshTokenRepository {

    private static final int TOKEN_LENGTH = 64;
    private static final int TOKEN_DURATION = 14; //days

    private final CrudRefreshTokenRepository crudRefreshTokenRepository;
    private final CrudUserRepository crudUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RefreshTokenJpaRepository(CrudRefreshTokenRepository crudRefreshTokenRepository,
                                     CrudUserRepository crudUserRepository,
                                     PasswordEncoder passwordEncoder) {
        this.crudRefreshTokenRepository = crudRefreshTokenRepository;
        this.crudUserRepository = crudUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String createRefreshToken(Long userId) {
        byte[] randomBytes = new byte[TOKEN_LENGTH];
        new SecureRandom().nextBytes(randomBytes);
        String token = Base64.getUrlEncoder().encodeToString(randomBytes);

        String tokenHash = hashToken(token);
        LocalDateTime expiryDate = LocalDateTime.now().plusDays(TOKEN_DURATION);

        RefreshTokenEntity refreshTokenEntity = new RefreshTokenEntity();
        refreshTokenEntity.setTokenHash(tokenHash);
        refreshTokenEntity.setUser(crudUserRepository.findById(userId).orElseThrow());
        refreshTokenEntity.setExpiryDate(expiryDate);
        refreshTokenEntity.setCreatedAt(LocalDateTime.now());

        crudRefreshTokenRepository.save(refreshTokenEntity);

        return token;
    }

    @Override
    public RefreshToken validateToken(String token) {
        String tokenHash = hashToken(token);
        RefreshTokenEntity refreshToken = crudRefreshTokenRepository.findByTokenHash(tokenHash).orElseThrow();

        if (refreshToken.getExpiryDate().isAfter(LocalDateTime.now())) {
            return refreshToken.toDomainModel();
        }

        throw new RuntimeException("Token expired!");
    }

    @Override
    public void deleteToken(String token) {
        String tokenHash = hashToken(token);
        crudRefreshTokenRepository.deleteByTokenHash(tokenHash);
    }

    private String hashToken(String token) {
        return passwordEncoder.encode(token);
    }
}
