package com.yqy.life;

public class User {

    //无参数构造器
    public User() {
        System.out.println("1 调用无参数构造器创建bean对象...");
    }

    //初始化的方法
    public void initMethod() {
        System.out.println("4 bean对象初始化，调用指定的初始化方法...");
    }

    //销毁的方法
    public void destroyMethod() {
        System.out.println("7 bean对象的销毁，调用指定的销毁方法...");
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("2 调用set方法给bean对象设置属性值...");
    }
}
