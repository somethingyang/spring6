package com.yqy.spring.tx.dao;

public interface BookDao {
    //根据图书id查询图书价格
    Integer getBookPriceByBookId(Integer bookId);

    //更新图书表的库存量
    void upDateStock(Integer bookId);

    //更新用户表余额-图书价格
    void updateUserBalance(Integer userId, Integer price);
}
