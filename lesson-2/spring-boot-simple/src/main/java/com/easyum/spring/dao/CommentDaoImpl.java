package com.easyum.spring.dao;

import com.easyum.spring.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentDaoImpl implements CommentDao {
    private final JdbcTemplate template;

    @Override
    public List<Comment> findCommentByTypeAndDate(String type, LocalDate localDate) {
        return null;
    }

    @Override
    public List<Comment> findAllCommentByUser(String username) {
        return null;
    }

    @Override
    public void addComment(Comment comment) {

    }
}
