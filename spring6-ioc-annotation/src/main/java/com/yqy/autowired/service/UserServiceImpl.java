package com.yqy.autowired.service;

import com.yqy.autowired.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    //注入dao
    //1 属性注入
//    @Autowired //根据类型找到对应对象，完成注入
//    private UserDao userDao;

    //2 set方法注入
//    private UserDao userDao;
//    @Autowired
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    //3 构造方法注入
//    private UserDao userDao;
//    @Autowired
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }

    //4 形参上注入
//    private UserDao userDao;
//    public UserServiceImpl(@Autowired UserDao userDao) {
//        this.userDao = userDao;
//    }

    //6 使用两个注解，@Autowired和@Qualifier("userRedisDaoImpl")根据名称进行注入
    @Autowired
    @Qualifier("userRedisDaoImpl")
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service add...");
        userDao.add();
    }
}
