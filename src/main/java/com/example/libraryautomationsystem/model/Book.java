package com.example.libraryautomationsystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookID;

    private String bookName;
    private String author;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
