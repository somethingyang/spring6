package com.yqy.resource;

import com.yqy.resource.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserController {
    public static void main(String[] args) {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("bean.xml");
        UserController userController = context.getBean(UserController.class);
        userController.add();
    }
}
