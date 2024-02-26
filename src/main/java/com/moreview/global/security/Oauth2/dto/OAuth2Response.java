package com.moreview.global.security.Oauth2.dto;

public interface OAuth2Response {

    String getProvider();  // 제공자 (Ex. naver, kakao)

    String getProviderId();  // 제공자에서 발급해주는 아이디(번호)

    String getEmail();  // 이메일

    String getName();  // 사용자 실명 (설정한 이름)
}
