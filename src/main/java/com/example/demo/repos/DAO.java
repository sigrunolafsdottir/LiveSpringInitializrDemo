package com.example.demo.repos;

import com.example.demo.models.Book;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DAO {

    public List<Book> getAllBooks() {
        Book b1 = new Book(1, "t1", "a1");
        Book b2 = new Book(2, "t2", "a2");
        Book b3 = new Book(3, "t3", "a3");
        Book b4 = new Book(4, "t4", "a4");
        Book b5 = new Book(5, "t5", "a5");
        Book b6 = new Book(6, "t6", "a6");

        List<Book> lista = new LinkedList<>();
        lista.add(b1);
        lista.add(b2);
        lista.add(b3);
        lista.add(b4);
        lista.add(b5);
        lista.add(b6);

        return lista;

    }
}
