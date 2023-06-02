package com.yqy.spring.tx;

import com.yqy.spring.tx.config.SpringConfig;
import com.yqy.spring.tx.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAnno {
    @Test
    public void testTxAllAnnotation(){
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        BookController accountService =
                applicationContext.getBean("bookController", BookController.class);
        accountService.buyBook(1, 1);
    }
}
