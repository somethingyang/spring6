package com.yqy.spring.xmltx.controller;

import com.yqy.spring.xmltx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;


    //买书方法：传递图书Id和用户id
    public void buyBook(Integer bookId,Integer userId) {
        //调用service方法
        bookService.buyBook(bookId,userId);
    }
}
