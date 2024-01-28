package com.crud.AWSDemo.repository;


import com.crud.AWSDemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
