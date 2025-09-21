package com.example.libraryManagementSystem.repo;

import com.example.libraryManagementSystem.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Integer> {
}
