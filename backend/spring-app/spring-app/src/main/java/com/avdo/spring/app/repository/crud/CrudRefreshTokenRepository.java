package com.avdo.spring.app.repository.crud;

import com.avdo.spring.app.repository.entity.RefreshToken;
import com.avdo.spring.app.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CrudRefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByTokenHash(String tokenHash);
    void deleteByTokenHash(String tokenHash);
    void deleteByUser(UserEntity user);
}
