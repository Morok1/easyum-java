package com.easyum.spring.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class User {
    private final String firstName;
    private final String secondName;
    private final String role;
}
