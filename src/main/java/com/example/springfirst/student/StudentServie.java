package com.example.springfirst.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
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


    public void deleteStudent(Long id) {
        boolean exists =repo.existsById(id);
        if (!exists){
            throw new IllegalStateException("no existing id  ");

        }
       repo.deleteById(id);
    }
@Transactional
    public Student updateStudent(Long id, String name, String email) {
        Student student =repo.findById(id).orElseThrow(() ->new IllegalStateException("Student with this id does nt exist"));

        if (name !=null && name.length()>0 &&
                !Objects.equals(student.getName(),name)){
            student.setName(name);
    }
    if (email !=null && email.length()>0 &&
            !Objects.equals(student.getEmail(),email)){
        Optional<Student> sop=repo.findStudentByEmail(email);
        if(sop.isPresent()){
            throw new IllegalStateException("email already  taken");
        }
        student.setEmail(email);
    }
    return student;

    }
}
