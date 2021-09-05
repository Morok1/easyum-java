package com.smagin.spring.example1;

import com.smagin.spring.configuration.Example1Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Example1Configuration.class);
        User1 bean = context.getBean(User1.class);
        System.out.println(bean.toString());
    }
}
