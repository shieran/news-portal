package com.hancharou.newsportal.service;

import com.hancharou.newsportal.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {

    Page<Comment> findAllComments(Pageable pageable);

    Comment createNewComment(Comment comment);
    
}
