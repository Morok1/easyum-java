package com.easyum.spring.service;

import com.easyum.spring.dao.CommentDao;
import com.easyum.spring.model.Comment;
import com.easyum.spring.service.api.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentDao commentDao;

    @Override
    public void addComment(Comment comment) {
        //check on not null
        //create checker utils module
        commentDao.addComment(comment);
    }

    @Override
    public List<Comment> getAllCommentsByTypeAndDate(String type, LocalDate localDate) {
        return commentDao.findCommentByTypeAndDate(type, localDate);
    }
}
