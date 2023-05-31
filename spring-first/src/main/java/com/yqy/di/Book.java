package com.yqy.di;

public class Book {
    private String bname;
    private String author;
    private String other;

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(String bname, String author) {
        System.out.println("有参数构造器执行了。。。");
        this.bname = bname;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", other='" + other + '\'' +
                '}';
    }

    public Book() {
        System.out.println("无参数构造器执行了。。。");
    }

    public static void main(String[] args) {

        //set方法注入
        Book book1 = new Book();
        book1.setBname("Java");
        book1.setAuthor("yqy");

        //构造方法注入
        Book book2 = new Book("Java","yqy");
    }
}
