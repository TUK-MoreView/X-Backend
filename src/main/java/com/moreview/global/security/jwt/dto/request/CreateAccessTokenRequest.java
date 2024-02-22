package com.moreview.global.security.jwt.dto.request;

import lombok.Getter;

@Getter
public class CreateAccessTokenRequest {

    private String refreshToken;
}
