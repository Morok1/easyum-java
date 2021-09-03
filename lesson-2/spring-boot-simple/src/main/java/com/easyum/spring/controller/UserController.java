package com.easyum.spring.controller;

import com.easyum.spring.model.User;
import com.easyum.spring.service.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/all-users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

}
