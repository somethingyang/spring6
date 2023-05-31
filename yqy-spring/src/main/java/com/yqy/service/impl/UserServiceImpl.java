package com.yqy.service.impl;

import com.yqy.anno.Bean;
import com.yqy.anno.Di;
import com.yqy.dao.UserDao;
import com.yqy.service.UserService;

@Bean
public class UserServiceImpl implements UserService {
    @Di
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("UserServiceImpl add...");
        userDao.add();
    }
}
