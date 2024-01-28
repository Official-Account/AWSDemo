package com.crud.AWSDemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long bookId;
    private String title;
    private  String author;
    private  String country;
    private  String language;
    private  String imageLink;
    private  String year;
    private  String link;
    private  int pages;

    private UUID isbn = UUID.randomUUID();
}