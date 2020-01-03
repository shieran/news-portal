package com.hancharou.newsportal.controller;

import com.hancharou.newsportal.dto.RegistrationDto;
import com.hancharou.newsportal.dto.UserDto;
import com.hancharou.newsportal.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public @ResponseBody UserDto newUserRegistration(@RequestBody RegistrationDto registrationDto) {
        return userService.register(registrationDto);
    }
}
