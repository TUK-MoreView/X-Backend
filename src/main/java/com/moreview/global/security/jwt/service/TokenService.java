//package com.moreview.global.security.jwt.service;
//
//import com.moreview.domain.member.Member;
//import com.moreview.domain.member.service.MemberService;
//import com.moreview.global.security.jwt.TokenProvider;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.time.Duration;
//
//@Service
//@RequiredArgsConstructor
//public class TokenService {
//
//    private final TokenProvider tokenProvider;
//    private final RefreshTokenService refreshTokenService;
//    private final MemberService memberService;
//
//    public String createNewAccessToken(String refreshToken) {
//        // 토큰 유효성 검사에 실패하면 예외 발생
//        if(!tokenProvider.validToken(refreshToken)) {
//            throw new IllegalArgumentException("Unexpected token");
//        }
//
//        Long memberId = refreshTokenService.findByRefreshToken(refreshToken).getMemberId();
//        Member member = memberService.findById(memberId);
//
//        return tokenProvider.generateToken(member, Duration.ofHours(2));
//    }
//}
