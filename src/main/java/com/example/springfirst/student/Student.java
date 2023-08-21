package com.example.springfirst.student;

import java.time.LocalDate;

public class Student {
    private String name;
    private Long id;
    private Integer age;
    private LocalDate dob;
    private String email;

    public Student(String name, Long id, Integer age, LocalDate dob, String email) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.dob = dob;
        this.email = email;
    }

    public Student(String name, Integer age, LocalDate dob, String email) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.email = email;
    }

    public Student(){

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                '}';
    }
}
