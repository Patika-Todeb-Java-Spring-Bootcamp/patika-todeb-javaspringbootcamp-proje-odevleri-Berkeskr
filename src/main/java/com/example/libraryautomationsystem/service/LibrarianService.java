package com.example.libraryautomationsystem.service;

import com.example.libraryautomationsystem.model.Book;
import com.example.libraryautomationsystem.repository.BookRepository;
import com.example.libraryautomationsystem.repository.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibrarianService {
    @Autowired
    private LibrarianRepository librarianRepository;
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        List<Book> allBooks = bookRepository.findAll();
        return allBooks;
    }

    public Book getBookByID(int bookID){
        Book book = bookRepository.findById(bookID).get();
        return book;
    }

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public boolean deleteBook(int bookID){
        boolean present = bookRepository.findById(bookID).isPresent();
        if(!present){
            return false;
        }
        Book book = bookRepository.findById(bookID).get();
        bookRepository.delete(book);
        return true;
    }

    public Book updateBook(int bookID, Book book){
        Optional<Book> bookById = bookRepository.findById(bookID);
        if(!bookById.isPresent()){
            return null;
        }
        Book updatedBook = bookById.get();
        updatedBook.setBookName(book.getBookName());
        updatedBook.setAuthor(book.getAuthor());
        //updatedBook.setBookID(book.getBookID());
        return bookRepository.save(updatedBook);
    }
}
