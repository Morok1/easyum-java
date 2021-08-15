package com.easyum.spring.service.api;

import com.easyum.spring.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> getAllUsers();
}
