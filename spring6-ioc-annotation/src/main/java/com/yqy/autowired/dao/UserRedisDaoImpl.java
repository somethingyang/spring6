package com.yqy.autowired.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserRedisDaoImpl implements UserDao{
    @Override
    public void add() {
        System.out.println("redis dao add...");
    }
}
