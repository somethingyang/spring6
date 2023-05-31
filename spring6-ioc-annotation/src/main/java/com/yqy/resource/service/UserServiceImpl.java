package com.yqy.resource.service;

import com.yqy.resource.dao.UserDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service(value = "myUserService")
public class UserServiceImpl implements UserService {


    //不指定名称会根据属性名称（myUserDao）自动注入
    @Resource
    private UserDao myUserDao;

    @Override
    public void add() {
        System.out.println("service add...");
        myUserDao.add();
    }
}
