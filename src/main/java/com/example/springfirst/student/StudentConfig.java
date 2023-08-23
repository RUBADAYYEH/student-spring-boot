package com.example.springfirst.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner clr(Repositry r){
        return (args ->{
            Student mary=new Student("mary","maryJeen@gmail.com",
                    LocalDate.of(2000, Month.APRIL, 5));

            Student deen=new Student("deen","DeenCuagro@gmail.com",
                    LocalDate.of(2001, Month.APRIL, 3));
            r.saveAll(List.of(mary,deen));


        }

        );

    }
}
