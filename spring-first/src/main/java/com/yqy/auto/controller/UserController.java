package com.yqy.auto.controller;

import com.yqy.auto.service.UserService;
import com.yqy.auto.service.UserServiceImpl;
import com.yqy.life.User;

public class UserController {

    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser() {
        System.out.println("userController方法执行了。。。");
        //调用service的方法
        userService.addUserService();
//        UserService userService = new UserServiceImpl();
//        userService.addUserService();
    }
}
