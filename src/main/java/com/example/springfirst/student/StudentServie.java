package com.example.springfirst.student;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class StudentServie {
    @GetMapping
    public String info(){
        return("this is a student ");
    }
}
