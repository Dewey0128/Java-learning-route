package com.george.pojo;

public class Book {
    private String name;
    private String author;


    public Book() {
        System.out.println("无参构造器执行了...");
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        System.out.println("有参构造器执行了...");
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{name = " + name + ", author = " + author + "}";
    }
}
