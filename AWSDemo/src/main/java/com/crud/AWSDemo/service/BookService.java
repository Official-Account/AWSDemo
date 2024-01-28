package com.crud.AWSDemo.service;

import com.crud.AWSDemo.entity.Book;
import com.crud.AWSDemo.exception.BookNotFoundException;
import com.crud.AWSDemo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService  implements  IBookService{


    @Autowired
    private final BookRepository bookRepository;

    @Override
    public List<Book> getAllBook(){
        return  bookRepository.findAll();
    }

    @Override
    public Book add(Book book){
        System.out.println("data: "+book.toString());
        return bookRepository.saveAndFlush(book);
    }
    @Override
    public Optional<Book> findById(Long bookId){

        return  Optional.ofNullable(bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("No book found with Id: " + bookId)));
    }

    @Override
    public  void delete(Long bookId){
        Optional<Book> theBook = findById(bookId);
        theBook.ifPresent(book -> bookRepository.deleteById(bookId));
    }

    @Override
    public  Book update(Book book){
        return bookRepository.saveAndFlush(book);
    }
}