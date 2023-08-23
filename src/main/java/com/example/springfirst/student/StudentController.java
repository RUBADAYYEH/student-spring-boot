package com.example.springfirst.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {


    private final StudentServie ss;
@Autowired
    public StudentController(StudentServie ss) {
        this.ss = ss;
    }
     @GetMapping
    public List<Student> info(){
        return ss.info();
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        ss.addNewStudent(student);
    }
    @DeleteMapping(path="{id}")
    public void deleteStudent(@PathVariable ("id") Long id ){
       ss.deleteStudent(id);
    }
    ///info ?
    //service layer
}
