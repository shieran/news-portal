package com.hancharou.newsportal.controller;

import com.hancharou.newsportal.entity.Comment;
import com.hancharou.newsportal.service.CommentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public @ResponseBody
    Page<Comment> findAllComments(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return commentService.findAllComments(pageable);
    }

    @PostMapping
    public @ResponseBody Comment createNewComment(@RequestBody Comment comment) {
        return commentService.createNewComment(comment);
    }
}
