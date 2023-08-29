package com.example.springfirst.student;

import lombok.Data;
import org.springframework.web.bind.annotation.ControllerAdvice;


@Data

public class EmailTakenException extends RuntimeException{
    private String message="Email Taken :(";
    public EmailTakenException(){

    }

    public String getMessage() {
        return message;
    }
}
