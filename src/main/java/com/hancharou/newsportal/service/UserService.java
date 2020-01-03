package com.hancharou.newsportal.service;

import com.hancharou.newsportal.dto.RegistrationDto;
import com.hancharou.newsportal.dto.UserDto;
import com.hancharou.newsportal.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    User findUserByUsername(String username);

    List<UserDto> findAllUsers(Pageable pageable);


    UserDto register(RegistrationDto registrationDto);

    void blockUser(Long id);

    void restoreUser(Long id);

}
