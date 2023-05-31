package com.yqy.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {
    private Object target; //目标对象

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //返回代理对象
    public Object getProxy() {
        /**
         * 三个参数
         * 1.类加载器 ClassLoader loader
         * 2.接口数组 Class<?>[] interfaces
         * 3.处理器 InvocationHandler h
         */
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            /**
             *
             * @param proxy 代理对象
             *
             * @param method 代理对象调用的方法
             *
             * @param args 代理对象调用的方法的参数
             *
             * @return 代理对象调用的方法的返回值
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method,Object[] args) throws Throwable {
                //前置通知
                System.out.println("[动态代理][日志] "+method.getName()+"，参数："+ Arrays.toString(args));
                //调用目标方法
                Object result = method.invoke(target, args);
                //后置通知
                System.out.println("[动态代理][日志] "+method.getName()+"，结果："+result);
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
