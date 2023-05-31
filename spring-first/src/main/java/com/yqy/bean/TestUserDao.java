package com.yqy.bean;

import org.apache.logging.log4j.core.util.JsonUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserDao {


    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");

        //根据类型获取接口对应的bean
        UserDao userDao =context.getBean(UserDao.class);
        System.out.println(userDao);
        userDao.run();
    }
}
