package com.example.libraryManagementSystem.controller;

import com.example.libraryManagementSystem.entity.Publisher;
import com.example.libraryManagementSystem.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController {
    
    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public ResponseEntity<List<Publisher>> listPublishers(){
        List<Publisher> publishers = publisherService.getAllPublishers();
        return ResponseEntity.ok(publishers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisher(@PathVariable int id){
        Publisher publisher = publisherService.getPublisherById(id);
        if(publisher == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(publisher);
    }

    @PostMapping
    public ResponseEntity<Publisher> savePublisher(@RequestBody Publisher publisher){
        Publisher createdPublisher = publisherService.saveOrUpdatePublisher(publisher);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPublisher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable int id, @RequestBody Publisher publisher){
        Publisher existingPublisher = publisherService.getPublisherById(id);
        if (existingPublisher == null){
            return ResponseEntity.notFound().build();
        }
        publisher.setId(id);
        publisherService.saveOrUpdatePublisher(publisher);
        return ResponseEntity.ok(publisher);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable int id){
        Publisher publisher = publisherService.getPublisherById(id);
        if(publisher == null){
            return ResponseEntity.notFound().build();
        }
        publisherService.deletePublisherById(id);
        return ResponseEntity.noContent().build();
    }
}
