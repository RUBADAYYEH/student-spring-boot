package com.example.springfirst.student;

import jakarta.transaction.Transactional;
import org.aspectj.apache.bcel.classfile.Module;
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
  @PutMapping(path = "{id}")
    public void updateStudent(@PathVariable("id")Long id , @RequestParam (required=false) String name , @RequestParam(required = false) String email){
        ss.updateStudent(id,name,email);
  }

    ///info ?
    //service layer
}
