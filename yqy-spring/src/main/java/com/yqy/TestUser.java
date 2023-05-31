package com.yqy;

import com.yqy.bean.AnnotationApplicationContext;
import com.yqy.bean.ApplicationContext;
import com.yqy.service.UserService;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationApplicationContext("com.yqy");
        UserService userService = (UserService) context.getBean(UserService.class);
        System.out.println(userService);
        userService.add();
    }
}
