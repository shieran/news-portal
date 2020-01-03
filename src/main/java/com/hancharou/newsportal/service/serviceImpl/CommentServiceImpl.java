package com.hancharou.newsportal.service.serviceImpl;

import com.hancharou.newsportal.entity.Comment;
import com.hancharou.newsportal.repo.CommentRepo;
import com.hancharou.newsportal.service.CommentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepo commentRepo;

    public CommentServiceImpl(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    @Override
    public Page<Comment> findAllComments(Pageable pageable) {
        return commentRepo.findAll(pageable);
    }

    @Override
    public Comment createNewComment(Comment comment) {
        return commentRepo.save(comment);
    }
}
