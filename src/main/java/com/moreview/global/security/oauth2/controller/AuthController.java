package com.moreview.global.security.oauth2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController {

    @GetMapping("/")
    @ResponseBody
    public String authAPI() {

        return "auth route";
    }
}
