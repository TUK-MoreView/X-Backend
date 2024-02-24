//package com.moreview.global.security.jwt;
//
//import jakarta.persistence.*;
//import lombok.AccessLevel;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Getter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//public class RefreshToken {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", updatable = false)
//    private Long id;
//
//    @Column(name = "member_id", nullable = false, unique = true)
//    private Long memberId;
//
//    @Column(name = "refresh_token", nullable = false)
//    private String refreshToken;
//
//    public RefreshToken(Long memberId, String refreshToken) {
//        this.memberId = memberId;
//        this.refreshToken = refreshToken;
//    }
//
//    public RefreshToken update(String newRefreshToken) {
//        this.refreshToken = newRefreshToken;
//
//        return this;
//    }
//}
