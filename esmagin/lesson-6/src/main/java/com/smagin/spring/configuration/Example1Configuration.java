package com.smagin.spring.configuration;

import com.smagin.spring.example1.User1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Example1Configuration {

    @Bean
    public User1 getUser(){
        return new User1("John");
    }

}
