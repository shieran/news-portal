package com.hancharou.newsportal.util;

import com.hancharou.newsportal.dto.UserDto;
import com.hancharou.newsportal.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDtoMapper {

    public UserDto map(User user) {
        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = new UserDto();
        modelMapper.map(user, userDto);
        return userDto;
    }

}
