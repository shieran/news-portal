package com.hancharou.newsportal.secutity.jwt;

import com.hancharou.newsportal.entity.User;
import com.hancharou.newsportal.enumeration.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getRole()),
                user.isActive()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Role userRole) {
        return new LinkedList<>(Collections.singleton(new SimpleGrantedAuthority(userRole.toString())));
    }
}
