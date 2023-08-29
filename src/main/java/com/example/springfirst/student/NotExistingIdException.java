package com.example.springfirst.student;


public class NotExistingIdException extends RuntimeException {
    private String message="USER ID NOT FOUND :(";
    public NotExistingIdException(){

    }

    @Override
    public String getMessage() {
        return message;
    }
}


