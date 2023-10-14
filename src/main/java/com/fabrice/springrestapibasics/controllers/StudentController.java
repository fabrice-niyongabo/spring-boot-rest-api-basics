package com.fabrice.springrestapibasics.controllers;

import com.fabrice.springrestapibasics.beans.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //path variables
    //we use @PatVariable to annotate the path variable
    //if the path variable is different with the function parameter name,
    //we have to provide the name of the path variable to the parameter.
    //the path variable is specified by {} within the route name or pathname.
    @GetMapping("/api/v1/student/{id}/{fName}")
    public Student getSingleStudent(@PathVariable("id") int studentId, @PathVariable String fName){
        return new Student(studentId,fName,"Kabera",25);
    }

    //query parameters
    //we use @RequestParameter to annotate the query param
    //http://localhost:8080/api/v1/student/query?id=13&fName=James
   @GetMapping("/api/v1/student/query")
    public Student getStudentByQueryParams(@RequestParam("id") int studentId, @RequestParam  String fName){
        return new Student(studentId,fName,"Kabera",25);
    }
    //POST request
    //we use @PostMapping annotation and @RequestBody to get the body of the request
    @PostMapping("/api/v1/student")
    @ResponseStatus(HttpStatus.CREATED) //1st method of changing return status code
    public Student CreateStudent(@RequestBody Student student){
        return student;
    }

    @PutMapping("/api/v1/student/{id}")
    //second way of change status code
    public ResponseEntity<Student>   updateStatudent(@RequestBody Student student, @PathVariable int studentId){
        Student std = new Student(studentId,student.getfName(),student.getlName(),student.getAge());
        // return ResponseEntity.ok(student);//this returns 200
        return new ResponseEntity<>(student , HttpStatus.CREATED); // 201
    }


}
