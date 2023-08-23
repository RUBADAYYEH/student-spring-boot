package com.example.springfirst.controller;
/*
import com.example.springfirst.dto.BookDTO;
import com.example.springfirst.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
/*
@TODO
** PathVariable
** Query Parameter
** RequestBody
** DTO (Data Transfer Object)
** DAO (Data Access Object)
 */
/*
@RestController
@RequestMapping("/books")
public class BookController {
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(new ArrayList<>(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getBook")
    public ResponseEntity<Book> getBookById(@RequestParam(required = false) String id){
        return new ResponseEntity<>(null, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @PostMapping public ResponseEntity<Book> createBook(@RequestBody BookDTO book) {
        return new ResponseEntity<>(new Book(book.getName(), book.getIsbn()), HttpStatus.CREATED);
    }


    @PostMapping("/reserve/{id}") public ResponseEntity<Book> reserveBook(@PathVariable String id) {
        return null;
    }

}*/

