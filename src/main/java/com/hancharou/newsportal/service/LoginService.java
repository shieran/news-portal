package com.hancharou.newsportal.service;

import com.hancharou.newsportal.dto.AuthenticationRequestDto;
import com.hancharou.newsportal.dto.TokenDto;

public interface LoginService {

    TokenDto loginDataCheck(AuthenticationRequestDto requestDto);

}
