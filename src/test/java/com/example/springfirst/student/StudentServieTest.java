package com.example.springfirst.student;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;


import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)

class StudentServieTest {

    private StudentServie ssUnderTest;
    @Mock
    private Repositry repo;// have to be mocked its tested already


    @BeforeEach
    void setUp(){


        ssUnderTest=new StudentServie(repo);
    }


    @Test
    void itShouldOutputinfo() {
        // when \
        ssUnderTest.info();
        verify(repo).findAll();         //only testing if the method in the service is invoking
                                              // this certain method in the repo .
    }

    @Test

    void canAddNewStudent() {
        //given
        Student student=new Student("jameela","j.ad@gmail.com", LocalDate.of(2005, Month.APRIL, 22));

        //when
        ssUnderTest.addNewStudent(student);
        //then
        ArgumentCaptor<Student> studentArgumentCaptor=ArgumentCaptor.forClass(Student.class);
        verify(repo).save(studentArgumentCaptor.capture());
        Student captured=studentArgumentCaptor.getValue();
        assertThat(captured).isEqualTo(student);

    }
    @Test

    void willThrowWhenEmailIsTaken() {
        //given
        Student student=new Student("jameela","j.ad@gmail.com", LocalDate.of(2005, Month.APRIL, 22));
       Mockito.when(repo.findStudentByEmail(student.getEmail())).thenReturn(
               // null);
                Optional.of(new Student("jameela","j.ad@gmail.com", LocalDate.of(2005, Month.APRIL, 22))));
        //when

        //then
        assertThatThrownBy(()->ssUnderTest.addNewStudent(student))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("email taken");
        verify(repo,never()).save(any());

    }

    @Test

    void shouldDeleteStudent() {
        Student student=new Student("jameela","j.ad@gmail.com", LocalDate.of(2005, Month.APRIL, 22));

        Mockito.when(repo.existsById(student.getId())).thenReturn(true);
        ssUnderTest.deleteStudent(student.getId());

        //then
        ArgumentCaptor<Long> studentArgumentCaptor=ArgumentCaptor.forClass(Long.class);
        verify(repo).deleteById(studentArgumentCaptor.capture());
        Long captured=studentArgumentCaptor.getValue();
        assertThat(captured).isEqualTo(student.getId());
    }
    @Test

    void shouldNotDeleteStudentWhenNotExist() {
        Student student=new Student("jameela","j.ad@gmail.com", LocalDate.of(2005, Month.APRIL, 22));

        Mockito.when(repo.existsById(student.getId())).thenReturn(false);


        assertThatThrownBy(()->ssUnderTest.deleteStudent(student.getId()))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no existing id  ");
        verify(repo,never()).delete(any());
    }
    @Test
    void shouldUpdateNameForExistingId(){
        final long uuid = 2;
        Student student=new Student(uuid,"jameela","j.ad@gmail.com", LocalDate.of(2005, Month.APRIL,20) ,22);

        Mockito.when(repo.findById(2L)).thenReturn(Optional.of(student));

        ssUnderTest.updateStudent(uuid,"Ahmad",null);

        Assertions.assertEquals("Ahmad",student.getName());


    }
    @Test
    void shouldNotUpdateNameWhenNotExist(){

        Student student=new Student(2L,"jameela","j.ad@gmail.com", LocalDate.of(2005, Month.APRIL, 22),4);

        Mockito.when(repo.findById(2L)).thenReturn(Optional.empty());


        assertThatThrownBy(()->ssUnderTest.updateStudent(student.getId(),"nnnn",null))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Student with this id does nt exist");

    }
    @Test
    void shouldUpdateEmailForExistingId(){
        final long uuid = 2;
        Student student=new Student(uuid,"jameela","j.ad@gmail.com", LocalDate.of(2005, Month.APRIL,20) ,22);

        Mockito.when(repo.findById(2L)).thenReturn(Optional.of(student));

        ssUnderTest.updateStudent(uuid,null,"Hani.h@gmail.com");

        Assertions.assertEquals("Hani.h@gmail.com",student.getEmail());


    }
    @Test
    void shouldNotUpdateEmailWhenNotExist(){

        Student student=new Student(2L,"jameela","j.ad@gmail.com", LocalDate.of(2005, Month.APRIL, 22),4);

        Mockito.when(repo.findById(2L)).thenReturn(Optional.empty());


        assertThatThrownBy(()->ssUnderTest.updateStudent(student.getId(),null,"nnnnnnnnn"))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Student with this id does nt exist");

    }
    @Test
    void willThrowWhenEmailIsTakenWhenUpdate() {
        //given
        Student student=new Student(2L,"jameela","j.ad@gmail.com", LocalDate.of(2005, Month.APRIL, 22),20);
        Mockito.when(repo.findById(2L)).thenReturn(Optional.of(student));
        Mockito.when(repo.findStudentByEmail("jllll.ad@gmail.com")).thenReturn(
                // null);
                Optional.of(new Student("juuty","jllll.ad@gmail.com", LocalDate.of(2005, Month.APRIL, 22))));
        //when

        //then
        assertThatThrownBy(()->ssUnderTest.updateStudent(2L,null,"jllll.ad@gmail.com"))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("email already  taken");


    }
}