package com.example.springfirst.student;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )

    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "student_sequence")
    private Long id;
    private String name;
   private String email;
   private LocalDate dob;
   @Transient
   private Integer age;


    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + setAge() +
                '}';
    }
    public int setAge(){
       return Period.between(dob,LocalDate.now()).getYears();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
