package com.example.libraryManagementSystem.repo;

import com.example.libraryManagementSystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
