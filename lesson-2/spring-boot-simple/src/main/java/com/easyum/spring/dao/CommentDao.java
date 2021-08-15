package com.easyum.spring.dao;

import com.easyum.spring.model.Comment;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface CommentDao {
    List<Comment> findCommentByTypeAndDate(String type, LocalDate localDate);

    List<Comment> findAllCommentByUser(String username);

    void addComment(Comment comment);
}
