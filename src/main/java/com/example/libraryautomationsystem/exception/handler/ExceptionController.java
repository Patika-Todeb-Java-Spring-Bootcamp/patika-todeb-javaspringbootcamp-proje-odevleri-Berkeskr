package com.example.libraryautomationsystem.exception.handler;

import com.example.libraryautomationsystem.exception.AdminAlreadyExist;
import com.example.libraryautomationsystem.exception.AdminNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;


@RestControllerAdvice
public class ExceptionController  {

    @ExceptionHandler(AdminNotFound.class)
    public ResponseEntity adminNotFoundException(AdminNotFound adminNotFound){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(adminNotFound.getMessage());

    }

    @ExceptionHandler(AdminAlreadyExist.class)
    public ResponseEntity adminAlreadyExistException(AdminAlreadyExist adminAlreadyExist){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(adminAlreadyExist.getMessage());
    }

}
