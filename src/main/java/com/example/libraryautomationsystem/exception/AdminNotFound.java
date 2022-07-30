package com.example.libraryautomationsystem.exception;

import javax.persistence.PersistenceException;

public class AdminNotFound extends RuntimeException {

    public AdminNotFound(String message) {
        super(message);
    }
}
