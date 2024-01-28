package com.crud.AWSDemo.service;

import com.crud.AWSDemo.entity.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {

    public List<Book> getAllBook();

    Book add(Book book);

    public Optional<Book> findById(Long bookId);

    public  void delete(Long bookId);

    public  Book update(Book book);
}
