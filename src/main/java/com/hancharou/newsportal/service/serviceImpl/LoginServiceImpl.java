package com.hancharou.newsportal.service.serviceImpl;

import com.hancharou.newsportal.dto.AuthenticationRequestDto;
import com.hancharou.newsportal.dto.TokenDto;
import com.hancharou.newsportal.entity.User;
import com.hancharou.newsportal.secutity.jwt.JwtTokenProvider;
import com.hancharou.newsportal.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class LoginServiceImpl implements LoginService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserServiceImpl userService;
    @Value("${jwt.token.expired}")
    private String tokenTimeForExpired;

    @Autowired
    public LoginServiceImpl(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserServiceImpl userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @Override
    public TokenDto loginDataCheck(@RequestBody AuthenticationRequestDto requestDto) {
        try {
            String username = requestDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            User user = userService.findUserByUsername(username);

            String token = jwtTokenProvider.createToken(username, user.getRole());
            return new TokenDto(token, username, tokenTimeForExpired);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException(e.getLocalizedMessage());
        }
    }

}
