package com.hancharou.newsportal.repo;

import com.hancharou.newsportal.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentRepo extends PagingAndSortingRepository<Comment, Long> {
    Page<Comment> findAll(Pageable pageable);
}
