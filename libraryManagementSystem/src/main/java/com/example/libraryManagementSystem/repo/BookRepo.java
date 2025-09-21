package com.example.libraryManagementSystem.repo;

import com.example.libraryManagementSystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {
}
