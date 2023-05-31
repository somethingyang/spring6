package com.yqy.dimap;

import java.util.List;
import java.util.Map;

public class Student {

    private List<Lesson> lessonList;

    private Map<String,Teacher> teacherMap;
    private String sid;
    private String sname;


    public void run() {
        System.out.println("学生ID：" + sid + "学生名字：" + sname);
        System.out.println("老师信息如下：" + teacherMap);
        System.out.println("课程信息如下：" + lessonList);
    }

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

}
