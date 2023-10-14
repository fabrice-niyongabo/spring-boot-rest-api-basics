package com.fabrice.springrestapibasics.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController is used to make our class an MVC controller
//it is a combination of both @Controller and @ResponseBody
@RestController
public class StudentController {

    // creating the entry point for our app
    @GetMapping("")
    public String homeRoute(){
        return "Server is running";
    }
}
