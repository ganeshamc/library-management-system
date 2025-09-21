package com.example.libraryManagementSystem.controller;

import com.example.libraryManagementSystem.entity.Author;
import com.example.libraryManagementSystem.service.AuthorService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> listAuthors(){
        List<Author> authors = authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable int id){
        Author author = authorService.getAuthorById(id);
        if(author == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(author);
    }

    @PostMapping
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author){
        Author createdAuthor = authorService.saveOrUpdateAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable int id, @RequestBody Author author){
        Author existingAuthor = authorService.getAuthorById(id);
        if (existingAuthor == null){
            ResponseEntity.notFound().build();
        }
        author.setId(id);
        authorService.saveOrUpdateAuthor(author);
        return ResponseEntity.ok(author);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable int id){
        Author author = authorService.getAuthorById(id);
        if(author == null){
            return ResponseEntity.notFound().build();
        }
        authorService.deleteAuthorById(id);
        return ResponseEntity.noContent().build();
    }

}
