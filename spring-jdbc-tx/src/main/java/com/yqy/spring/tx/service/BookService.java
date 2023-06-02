package com.yqy.spring.tx.service;

public interface BookService {

    //买书的方法：传递图书id和用户id
    void buyBook(Integer bookId, Integer userId);
}
