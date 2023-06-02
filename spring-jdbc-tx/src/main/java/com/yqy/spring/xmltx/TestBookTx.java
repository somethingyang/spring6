package com.yqy.spring.xmltx;

import com.yqy.spring.xmltx.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:beans-xml.xml")
public class TestBookTx {
    @Autowired
    private BookController bookController;

    @Test
    public void TestBuyBook() {
        bookController.buyBook(1,1);
    }
}
