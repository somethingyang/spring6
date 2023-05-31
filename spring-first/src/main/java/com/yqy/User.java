package com.yqy;

import org.junit.jupiter.api.Test;

public class User {

    //无参数构造器
    public User(){
        System.out.println("0：User无参数构造器执行了。。。");
    }

    public void add(){
        System.out.println("add.....");
    }

    public static void main(String[] args) {
        User user = new User();
        user.add();

    }



}









