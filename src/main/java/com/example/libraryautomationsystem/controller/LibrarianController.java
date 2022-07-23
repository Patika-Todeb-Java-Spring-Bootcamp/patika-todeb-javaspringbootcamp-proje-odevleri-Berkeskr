package com.example.libraryautomationsystem.controller;

import com.example.libraryautomationsystem.model.Book;
import com.example.libraryautomationsystem.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/librarian")
public class LibrarianController {

    @Autowired
    private LibrarianService librarianService;

    @GetMapping("/books")
    public ResponseEntity getAllBooks(){
        List<Book> allBooks = librarianService.getAllBooks();
        return ResponseEntity.ok(allBooks);
    }

    @GetMapping("/book/{bookID}")
    public ResponseEntity getBookByID(@PathVariable int bookID){
        return ResponseEntity.ok(librarianService.getBookByID(bookID));
    }

    @PostMapping("/book")
    public ResponseEntity createBook(@RequestBody Book book){
        Book createdBook = librarianService.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);

    }

    @DeleteMapping("/book/{bookID}")
    public ResponseEntity deleteBook(@PathVariable int bookID){
        boolean isPresent = librarianService.deleteBook(bookID);
        if (!isPresent){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Book deleted");
    }

    @PutMapping("/book/{bookID}")
    public ResponseEntity updateBook(@PathVariable int bookID,@RequestBody Book book){
        Book updateBook = librarianService.updateBook(bookID, book);
        if(updateBook==null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Update failed");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Update successfull");
    }
}
