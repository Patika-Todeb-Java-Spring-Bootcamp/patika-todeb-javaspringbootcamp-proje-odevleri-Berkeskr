package com.example.libraryautomationsystem.repository;

import com.example.libraryautomationsystem.model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian,Integer> {
}
