//package com.moreview.global.security.Oauth2.service;
//
//import com.moreview.domain.member.Member;
//import com.moreview.domain.member.repository.MemberRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Service;
//
//import java.util.Map;
//
//@Service
//@RequiredArgsConstructor
//public class OAuth2UserCustomService extends DefaultOAuth2UserService {
//
//    private final MemberRepository memberRepository;
//
//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//        OAuth2User user = super.loadUser(userRequest); // 1. 요청을 바탕으로 유저 정보를 담은 객체 반환
//        saveOrUpdate(user);
//
//        return user;
//    }
//
//    // 2. 유저가 있으면 업데이트, 없으면 유저 생성
//    private Member saveOrUpdate(OAuth2User oAuth2User) {
//        Map<String, Object> attributes = oAuth2User.getAttributes();
//
//        String email = (String) attributes.get("email");
//        String name = (String) attributes.get("name");
//
//        Member member = memberRepository.findByEmail(email)
//                .map(entity -> entity.update(name))
//                .orElse(Member.builder()
//                        .email(email)
//                        .nickname(name)
//                        .build());
//
//        return memberRepository.save(member);
//    }
//}
