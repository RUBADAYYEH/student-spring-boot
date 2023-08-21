package com.example.springfirst.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {


    private final StudentServie ss;

    public StudentController(StudentServie ss) {
        this.ss = ss;
    }
     @GetMapping
    public String info(){
        return ss.info();
    }
    ///info ?
    //service layer
}
