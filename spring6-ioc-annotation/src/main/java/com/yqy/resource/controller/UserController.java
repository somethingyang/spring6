package com.yqy.resource.controller;

import com.yqy.resource.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller("MyUserController")
public class UserController {

    //根据名称（myUserService）注入
//    @Resource(name = "myUserService")
//    private UserService userService;

    //根据类型注入,名字和属性都不一致也可以注入成功
    @Resource
    private UserService userService;

    public void add(){
        System.out.println("controller add...");
        userService.add();
    }
}
