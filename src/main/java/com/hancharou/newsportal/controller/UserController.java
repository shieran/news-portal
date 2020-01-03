package com.hancharou.newsportal.controller;

import com.hancharou.newsportal.dto.UserDto;
import com.hancharou.newsportal.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.core.Response;
import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public @ResponseBody
    List<UserDto> findAll(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return userService.findAllUsers(pageable);
    }

    @GetMapping(path = "/{id}/block")
    public @ResponseBody Response blockUser(@PathVariable Long id) {
        userService.blockUser(id);
        return Response.status(Response.Status.OK).build();
    }

    @GetMapping(path = "/{id}/restore")
    public @ResponseBody Response restoreUser(@PathVariable Long id) {
        userService.restoreUser(id);
        return Response.status(Response.Status.OK).build();
    }

}
