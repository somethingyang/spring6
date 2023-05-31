package com.yqy.resource;

import com.yqy.config.SpringConfig;
import com.yqy.resource.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUserControllerAnno {
    public static void main(String[] args) {
        //加载配置类实现
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController userController = context.getBean(UserController.class);
        userController.add();
    }
}
