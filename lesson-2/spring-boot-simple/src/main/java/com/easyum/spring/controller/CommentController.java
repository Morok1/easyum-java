package com.easyum.spring.controller;

import com.easyum.spring.model.Comment;
import com.easyum.spring.service.api.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/all-comments-by-date-and-type")
    public List<Comment> getAllCommentsByDateAndType(@RequestParam String type, @RequestParam LocalDate date ){
        return commentService.getAllCommentsByTypeAndDate(type, date);
    }

    @GetMapping("/hello")
    public String getAllCommentsByDateAndType(){
        return "hello";
    }
}
