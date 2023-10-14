package com.fabrice.springrestapibasics.controllers;

import com.fabrice.springrestapibasics.beans.Student;
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

    //retuning a bean
    //if you dont provide the status code, spring boot will provide a default status code of 200
    @GetMapping("/api/v1/student")
    public Student getStudent(){
        Student std = new Student(1,"Fabrice","Niyongabo",44);
        return std;
    }
}
