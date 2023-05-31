package com.yqy.ditest;

import java.util.Arrays;

//员工类
public class Emp {

    //员工属于某个部门(对象类型属性)
    private Dept dept;
    private String ename;
    private Integer age;

    //爱好
    private String[] loves;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String[] getLoves() {
        return loves;
    }

    public void setLoves(String[] loves) {
        this.loves = loves;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void work() {
        System.out.println(ename+ "正在工作...." +age);
        dept.info();
        System.out.println(Arrays.toString(loves));
    }


}
