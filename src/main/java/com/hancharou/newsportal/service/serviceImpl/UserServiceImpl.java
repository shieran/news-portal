package com.hancharou.newsportal.service.serviceImpl;

import com.hancharou.newsportal.dto.RegistrationDto;
import com.hancharou.newsportal.dto.UserDto;
import com.hancharou.newsportal.entity.User;
import com.hancharou.newsportal.enumeration.Role;
import com.hancharou.newsportal.repo.UserRepo;
import com.hancharou.newsportal.service.UserService;
import com.hancharou.newsportal.util.UserToUserDtoMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserToUserDtoMapper userToUserDtoMapper;
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo userRepo, UserToUserDtoMapper userToUserDtoMapper, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.userToUserDtoMapper = userToUserDtoMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepo.findUserByUsername(username);
    }

    @Override
    public List<UserDto> findAllUsers(Pageable pageable) {
        List<UserDto> usersDto = new LinkedList<>();
        userRepo.findAll(pageable)
                .forEach(u -> usersDto.add(userToUserDtoMapper.map(u)));
        return usersDto;
    }

    @Override
    public UserDto register(RegistrationDto registrationDto) {
        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setRole(Role.USER);
        user.setActive(true);
        return userToUserDtoMapper.map(userRepo.save(user));
    }

    @Override
    public void blockUser(Long id) {
        User user = userRepo.findUserById(id);
        user.setActive(false);
        userRepo.save(user);
    }

    @Override
    public void restoreUser(Long id) {
        User user = userRepo.findUserById(id);
        user.setActive(true);
        userRepo.save(user);
    }
}
