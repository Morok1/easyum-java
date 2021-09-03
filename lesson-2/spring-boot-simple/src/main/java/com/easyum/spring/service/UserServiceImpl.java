package com.easyum.spring.service;

import com.easyum.spring.dao.UserDao;
import com.easyum.spring.model.User;
import com.easyum.spring.service.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public void addUser(User user) {
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAllUsers();
    }
}
