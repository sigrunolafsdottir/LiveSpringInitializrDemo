package com.example.demo.controllers;


import com.example.demo.models.Book;
import com.example.demo.models.Greeting;
import com.example.demo.repos.DAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FormController {

    DAO db = new DAO();
    List<Book> mybooks = db.getAllBooks();

    @GetMapping(path = "/allBooks")
    public String getAllBooks(Model model) {
        model.addAttribute("allBooks", mybooks);
        return "allBooks";
    }


    @GetMapping ("/addBooks")
    public String index2() {
        System.out.println("addBooks ");
        return "index";
    }



    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        System.out.println("greeting 1");
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        System.out.println("greeting 2");
        model.addAttribute("greeting", greeting);
        return "result";
    }
}
