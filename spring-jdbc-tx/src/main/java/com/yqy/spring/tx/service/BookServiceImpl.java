package com.yqy.spring.tx.service;

import com.yqy.spring.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Transactional(timeout = 10,noRollbackFor = ArithmeticException.class)
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDao bookDao;

    @Override
    public void buyBook(Integer bookId, Integer userId) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //根据图书id查询图书价格
        Integer price = bookDao.getBookPriceByBookId(bookId);

        //更新图书表的库存量
        bookDao.upDateStock(bookId);

        //更新用户表余额-图书价格
        bookDao.updateUserBalance(userId,price);
//        System.out.println(1/0);
    }
}
