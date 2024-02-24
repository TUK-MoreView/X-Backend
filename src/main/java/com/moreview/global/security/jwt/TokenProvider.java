//package com.moreview.global.security.jwt;
//
//import com.moreview.domain.member.Member;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Header;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.stereotype.Service;
//
//import java.time.Duration;
//import java.util.Collections;
//import java.util.Date;
//import java.util.Set;
//
//@Service
//@RequiredArgsConstructor
//public class TokenProvider {
//
//    private final JwtProperties jwtProperties;
//
//    public String generateToken(Member member, Duration expiredAt) {
//        Date now = new Date();
//        return makeToken(new Date(now.getTime() + expiredAt.toMillis()), member);
//    }
//
//    private String makeToken(Date expiry, Member member) {
//        Date now = new Date();
//
//        return Jwts.builder()
//                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
//                .setIssuer(jwtProperties.getIssuer())
//                .setIssuedAt(now)
//                .setExpiration(expiry)
//                .setSubject(member.getEmail())
//                .claim("id", member.getId())
//                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
//                .compact();
//    }
//
//    public boolean validToken(String token) {
//        try {
//            Jwts.parser()
//                    .setSigningKey(jwtProperties.getSecretKey())
//                    .parseClaimsJws(token);
//
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public Authentication getAuthentication(String token) {
//        Claims claims = getClaims(token);
//        Set<SimpleGrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_MEMBER"));
//
//        return new UsernamePasswordAuthenticationToken(new org.springframework.security.core.userdetails.User(claims.getSubject
//                (), "", authorities), token, authorities);
//    }
//
//    public Long getMemberId(String token) {
//        Claims claims = getClaims(token);
//        return claims.get("id", Long.class);
//    }
//
//    private Claims getClaims(String token) {
//        return Jwts.parser()
//                .setSigningKey(jwtProperties.getSecretKey())
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//}
