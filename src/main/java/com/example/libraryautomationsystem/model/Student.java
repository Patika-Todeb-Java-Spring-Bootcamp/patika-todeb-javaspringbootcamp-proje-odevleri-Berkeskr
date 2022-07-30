package com.example.libraryautomationsystem.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Student extends User{

    @OneToMany(mappedBy = "student")
    private List<Book> books;
}
