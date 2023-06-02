package com.yqy.spring.xmltx.service;

import com.yqy.spring.xmltx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public void buyBook(Integer bookId, Integer userId) {
        //根据图书id查询图书价格
        Integer price = bookDao.getBookPriceByBookId(bookId);

        //更新图书表的库存量
        bookDao.upDateStock(bookId);

        //更新用户表余额-图书价格
        bookDao.updateUserBalance(userId,price);
    }
}
