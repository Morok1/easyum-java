package com.easyum.spring.dao;

import com.easyum.spring.model.User;

import java.util.List;

public interface UserDao {
    User findUserByName(String name);

    List<User> findAllUsers();

    void addUser(User user);
}
