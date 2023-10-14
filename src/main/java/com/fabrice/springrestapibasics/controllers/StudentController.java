package com.fabrice.springrestapibasics.controllers;

import com.fabrice.springrestapibasics.beans.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    //returning a list(array) of java bean
    //here the return type of this endpoint will be a list of students List<Student>
    @GetMapping("/api/v1/students")
    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(11,"Kamana","Fidel",30));
        students.add(new Student(3,"Fabrice","Niyongabo",30));
        students.add(new Student(4,"James","Bond",18));
        return students;
    }
}
