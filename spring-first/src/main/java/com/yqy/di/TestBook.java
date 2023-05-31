package com.yqy.di;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBook {
    @Test
    public void testSetter(){
        //set方法注入
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beandi.xml");
        Book book1 = context.getBean("book", Book.class);
        System.out.println(book1);
    }

    @Test
    public void testConstructor(){
        //构造方法注入
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beandi.xml");
        Book book2 = context.getBean("bookCon", Book.class);
        System.out.println(book2);
    }

}
