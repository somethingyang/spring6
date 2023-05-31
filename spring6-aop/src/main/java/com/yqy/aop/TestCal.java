package com.yqy.aop;

public class TestCal {
    public static void main(String[] args) {
        //创建代理对象
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(1, 2);
        proxy.sub(1, 2);
    }
}
