package com.yqy.spring.tx;

import com.yqy.spring.tx.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class TestBookTx {
    @Autowired
    private BookController bookController;

    @Test
    public void TestBuyBook() {
        bookController.buyBook(1,1);
    }
}
