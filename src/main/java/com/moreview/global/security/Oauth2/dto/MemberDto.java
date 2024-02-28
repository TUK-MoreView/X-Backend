package com.moreview.global.security.Oauth2.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
public class MemberDto {

    private String role;
    private String name;
    private String memberName;
}
