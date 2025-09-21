package com.example.libraryManagementSystem.repo;

import com.example.libraryManagementSystem.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepo extends JpaRepository<Publisher, Integer> {
}
