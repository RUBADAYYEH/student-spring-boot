package com.example.springfirst.student;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

@DataJpaTest
public class StudentRepoTest {
    @Autowired
    private Repositry repoUnderTest;


    @AfterEach
    void tearDown(){
        repoUnderTest.deleteAll();
    }

    @Test
    void StudentsWithEmailExist() {
         Student student=new Student("jameela","j.ad@gmail.com", LocalDate.of(2005, Month.APRIL, 22));
         Optional input=Optional.of(student);
        repoUnderTest.save(student);
        //when
        Optional<Student> resultedStudent= repoUnderTest.findStudentByEmail("j.ad@gmail.com");


        //then
        Assertions.assertThat(resultedStudent).isEqualTo(input);


    }
    @Test
    void noStudentWithEmailExists() {


            Student student=new Student("jameela","j.ad@gmail.com", LocalDate.of(2005, Month.APRIL, 22));
            Optional input=Optional.of(student);

            //when
            Optional<Student> resultedStudent= repoUnderTest.findStudentByEmail("j.ad@gmail.com");


            //then
            Assertions.assertThat(resultedStudent).isEmpty();







    }






}
