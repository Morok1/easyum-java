package com.easyum.spring.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class Comment {
    private final String text;
    private final LocalDateTime time;


}
