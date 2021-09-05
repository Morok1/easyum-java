package com.smagin.spring.example2;

import com.smagin.spring.configuration.Example2Configuration;
import com.smagin.spring.example1.User1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.smagin.spring");
        Example2Dao dao = context.getBean(Example2Dao.class);
        Example2Controller controller = context.getBean(Example2Controller.class);

        System.out.println(dao.toString());
        System.out.println(controller.toString());
    }
}
