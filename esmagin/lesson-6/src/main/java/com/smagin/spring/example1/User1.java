package com.smagin.spring.example1;

import lombok.ToString;

@ToString
public class User1 {
    private final String name;

    public User1(String name) {
        this.name = name;
    }
}
