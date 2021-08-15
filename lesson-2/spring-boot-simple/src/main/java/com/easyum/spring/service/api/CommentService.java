package com.easyum.spring.service.api;

import com.easyum.spring.model.Comment;

import java.time.LocalDate;
import java.util.List;

public interface CommentService {
    void addComment(Comment comment);

    List<Comment> getAllCommentsByTypeAndDate(String type, LocalDate localDate);
}
