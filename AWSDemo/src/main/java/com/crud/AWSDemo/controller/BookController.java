package com.crud.AWSDemo.controller;

import com.crud.AWSDemo.service.BookService;
import com.crud.AWSDemo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/aws/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<Book> add(@RequestBody Book book){
        return  new ResponseEntity<>(bookService.add(book), CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks(){
        return  ResponseEntity.ok(bookService.getAllBook());
    }

    @GetMapping("/book/{bid}")
    public Optional<Book> getById(@PathVariable("bid") Long bookId){
        return bookService.findById(bookId);
    }

    @PutMapping("/book/update")
    public ResponseEntity<Book>  update(@RequestBody Book theBook){
        return  new ResponseEntity<>(bookService.update(theBook), OK);
    }

    @DeleteMapping("/book/delete/{bid}")
    public  void delete(@PathVariable("bid") Long boookId){
        bookService.delete(boookId);
    }

}
