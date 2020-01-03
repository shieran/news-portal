package com.hancharou.newsportal.controller;

import com.hancharou.newsportal.dto.AuthenticationRequestDto;
import com.hancharou.newsportal.dto.TokenDto;
import com.hancharou.newsportal.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public @ResponseBody TokenDto userAuthentication (@RequestBody AuthenticationRequestDto requestDto) {
        return loginService.loginDataCheck(requestDto);
    }

}
