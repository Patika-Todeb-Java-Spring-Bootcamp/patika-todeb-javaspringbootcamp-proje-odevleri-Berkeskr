package com.example.libraryautomationsystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String surname;
    private String email;

    public void getPersonalInfo(){
        System.out.println("Name: "+this.name+" Surname: "+this.surname);
    }
}
