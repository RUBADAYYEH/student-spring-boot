package com.example.springfirst.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServie {
    public final Repositry repo ;

    @Autowired
    public StudentServie(Repositry repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Student> info(){
        return repo.findAll();
    }

    public void addNewStudent(Student student) {
        System.out.println(student);
       Optional<Student> studentByEmail= repo.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
       repo.save(student);


    }
}
