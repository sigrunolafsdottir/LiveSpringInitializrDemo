package com.example.demo.controllers;

//CRUD = create, read, update, delete

import com.example.demo.models.Book;
import com.example.demo.repos.DAO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    DAO db = new DAO();
    List<Book> mybooks = db.getAllBooks();

    @RequestMapping("/books")
    public List<Book> books() {
        return mybooks;
    }


}
