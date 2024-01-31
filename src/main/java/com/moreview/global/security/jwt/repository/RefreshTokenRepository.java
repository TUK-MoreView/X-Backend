package com.moreview.global.security.jwt.repository;

import com.moreview.global.security.jwt.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByMemberId(Long MemberId);
    Optional<RefreshToken> findByRefreshToken(String refreshToken);
}

