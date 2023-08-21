package com.example.springfirst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication

public class SpringfirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringfirstApplication.class, args);
    }
   /* @GetMapping
    public String info(){
        return("this is a student ");
    }*/
   /* @GetMapping
    public List<String> infoList(){
        return List.of("hello",
                "for this ",
                "student"

        );*
    }*/

}
