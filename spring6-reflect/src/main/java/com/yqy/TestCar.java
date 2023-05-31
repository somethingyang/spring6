package com.yqy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.attribute.UserPrincipal;

public class TestCar {
    //1 获取Class对象
    @Test
    public void test01() throws Exception {
        //1 类名.class
        Class clazz1 = Car.class;

        //2 对象.getClass()
        Class clazz2 = new Car().getClass();

        //3 Class.forName("全类名")
        Class clazz3 = Class.forName("com.yqy.Car");

        //实例化Class对象
        Car car = (Car) clazz3.getDeclaredConstructor().newInstance();
        System.out.println(car);
    }
    //2 获取构造方法
    @Test
    public void test02() throws Exception {
        Class clazz = Car.class;
        //1 获取所有的构造方法（getDeclaredConstructors()可以获取所有构造方法，getConstructors()只可以获取public修饰的）
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors) {
            System.out.println("构造方法名称："+c.getName() + "  参数个数："+c.getParameterCount());
        }

        //2 获取指定的构造方法

        //2.1 获取public修饰的构造方法
//        Constructor c1 = clazz.getConstructor(String.class, int.class, String.class);
//        Car car1 = (Car) c1.newInstance("奔驰", 3, "黑色");
//        System.out.println(car1);

        //2.2 获取private修饰的构造方法
        Constructor c2 = clazz.getDeclaredConstructor(String.class, int.class, String.class);
        c2.setAccessible(true);
        Car car2 = (Car) c2.newInstance("宝马", 5, "白色");
        System.out.println(car2);
    }
    
    //3 获取属性
    @Test
    public void test03() throws Exception {
        Class clazz = Car.class;
        Car car = (Car) clazz.getDeclaredConstructor().newInstance();
        //1 获取所有的属性（getDeclaredFields()可以获取所有属性，getFields()只可以获取public修饰的）
//        Field[] fields = clazz.getFields();
        //获取所用属性（包含私有属性）
        Field[] fields1 = clazz.getDeclaredFields();
        for (Field f : fields1) {
            if (f.getName().equals("name")){
                //设置允许访问
                f.setAccessible(true);
                f.set(car,"奔驰");
            }
            System.out.println(f.getName());
            System.out.println(car);
        }
    }
    //4 获取方法
    @Test
    public void test04() throws Exception {
        Car car = new Car("奔驰", 3, "黑色");
        Class clazz = car.getClass();
        //1 获取所有的方法（getDeclaredMethods()可以获取所有方法，getMethods()只可以获取public修饰的）
        //1 public修饰的方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
//            System.out.println("方法名字："+m.getName());

            //执行方法toString()
            if (m.getName().equals("toString")){
                String invoke = (String) m.invoke(car);
                System.out.println("toString方法执行： "+invoke);
            }
        }

        //2 private修饰的方法
        Method[] methodsAll = clazz.getDeclaredMethods();
        for (Method m : methodsAll) {
            //执行方法run()
            if (m.getName().equals("run")){
                //设置允许访问
                m.setAccessible(true);
                m.invoke(car);
            }
        }
    }
    
}
