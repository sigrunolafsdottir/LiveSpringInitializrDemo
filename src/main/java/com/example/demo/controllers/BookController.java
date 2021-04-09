package com.example.demo.controllers;

//CRUD = create, read, update, delete

import com.example.demo.models.Book;
import com.example.demo.models.Message;
import com.example.demo.repos.DAO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class BookController {

    DAO db = new DAO();
    List<Book> mybooks = db.getAllBooks();

    @RequestMapping("/books")
    public List<Book> books() {
        return mybooks;
    }

    @RequestMapping("/book/{id}")
    public Book bookById(@PathVariable int id) {
        for (Book b : mybooks){
            if (b.getId() == id){
                return b;
            }
        }
        return null;
    }

    @RequestMapping("/book/{id}/delete")
    public String deleteBookById(@PathVariable int id) {
        int indexToRemove = -1;

        for (int i = 0; i < mybooks.size(); i++){
            if (mybooks.get(i).getId() == id){
                indexToRemove = i;
            }
        }
        if(indexToRemove != -1) {
            mybooks.remove(indexToRemove);
            return "Boken med id "+id+"är borttagen";

        }
        return "Boken med id "+id+"kunde inte tas bort";
    }

    @PostMapping("/book/add")
    public String addBook(@RequestBody Book b){
        mybooks.add(b);
        return "book added";
    }

    @PostMapping("/book/upsert")
    public Message upsertBook(@RequestBody Book b){
        int indexToUpdate = -1;

        for (int i = 0; i < mybooks.size(); i++){
            if (mybooks.get(i).getId() == b.getId()){
                indexToUpdate = i;
            }
        }
        if (indexToUpdate == -1){
            mybooks.add(b);
            Message m = new Message(true, "Book was created");
            return m;
        }
        else{
            mybooks.set(indexToUpdate, b);
            Message m = new Message(true, "Book was updated");
            return m;
        }

    }


}
