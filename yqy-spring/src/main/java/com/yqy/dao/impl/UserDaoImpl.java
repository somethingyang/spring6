package com.yqy.dao.impl;

import com.yqy.anno.Bean;
import com.yqy.dao.UserDao;

@Bean
public class UserDaoImpl implements UserDao{
    @Override
    public void add() {
        System.out.println("UserDaoImpl add...");
    }
}
