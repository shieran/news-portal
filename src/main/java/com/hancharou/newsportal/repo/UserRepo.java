package com.hancharou.newsportal.repo;

import com.hancharou.newsportal.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepo extends PagingAndSortingRepository<User, Long> {
    User findUserByUsername(String username);
    Page<User> findAll(Pageable pageable);
    User findUserById(Long id);
}

