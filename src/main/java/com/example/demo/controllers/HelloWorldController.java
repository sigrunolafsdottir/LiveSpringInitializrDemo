package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
public class HelloWorldController {

    /*
    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }
*/



    @RequestMapping("/a")
    public String index2() {
        return "Hello Worldaaaaaaa";
    }

    @RequestMapping("/hej")
    public String hej(@RequestParam(required = false) String name) {
        if (name == null) return "Hello World";
        return "Hello " + name;
    }

    @RequestMapping("/hej2")
    public String hej2(@RequestParam(defaultValue = "Sigrun") String firstname,
                       @RequestParam(defaultValue = "Olafsdottir") String lastname) {
        return "Hello " + firstname + " " + lastname;
    }

    //anropas: http://localhost:8080/hej3?names=sigrun,soley,olafsdottir
    //alternativt http://localhost:8080/hej3?names=sigrun&names=soley&names=olafsdottir

    @RequestMapping("/hej3")
    public String hej3(@RequestParam List<String> names) {
        return "Hello " + names;
    }

    @RequestMapping("/hejPathParam/{name}")
    public String hejPathParam(@PathVariable String name) {
        if (name == null) return "Hello World";
        return "Hello " + name;
    }

    //mha denna metod blir name optional (tillsammans med ovanstående metod)
    @RequestMapping("/hejPathParam")
    public String hejPathParamtest() {
        return "Hello ";
    }

    //man skulle kunna tro att detta skulle göra name optional, men det funkar tyvärr inte
    @RequestMapping(value = {"/hejPathParam2", "/hejPathParam2/{name}"})
    public String hejPathParam2(@PathVariable(required = false) String name) {
        if (name == null) return "Hello World";
        return "Hello " + name;
    }

    @RequestMapping(value = {"/list", "/list/{stuff}", "other", "/{stuff}/other"})
    public String list(@PathVariable(required = false) List<String> stuff) {
        if (stuff == null) {
            return "no data";
        }
        return "received: " + stuff;
    }


    //man skulle kunna tro att detta skulle göra name optional, men det funkar tyvärr inte
    @RequestMapping(value = {"/hejPathParam3", "/hejPathParam3/{name}"})
    public String hejPathParam3(@PathVariable Optional<String> name) {
        if (name.isEmpty()) return "Hello World";
        return "Hello " + name.get();
    }

    @RequestMapping(value = "/hejhtml")
    public String hejhtml() {
        return "<html><head></head><body>hej på er</body></html>";
    }


}
