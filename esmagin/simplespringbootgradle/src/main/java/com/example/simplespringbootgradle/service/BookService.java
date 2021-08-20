package com.example.simplespringbootgradle.service;

import com.example.simplespringbootgradle.model.Book;
import com.example.simplespringbootgradle.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(Book.builder().name("author").id(1l).build());
    }
}
