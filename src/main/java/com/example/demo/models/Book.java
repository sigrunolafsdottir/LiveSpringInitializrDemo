package com.example.demo.models;

public class Book {


    //cleaning up conflict


    protected int id;
    protected String title;
    protected String author;

    public Book(){}

    public Book(int id, String title, String author){
        this.id = id;
        this.author=author;
        this.title = title;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
