package com.example.libraryManagementSystem.service;

import com.example.libraryManagementSystem.entity.Author;
import com.example.libraryManagementSystem.entity.Publisher;
import com.example.libraryManagementSystem.repo.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepo publisherRepo;

    public List<Publisher> getAllPublishers(){
        return publisherRepo.findAll();
    }

    public Publisher getPublisherById(int id){
        return publisherRepo.findById(id)
                .orElse(null);
    }

    public Publisher saveOrUpdatePublisher(Publisher publisher){
        return publisherRepo.save(publisher);
    }

    public void deletePublisherById(int id){
        publisherRepo.findById(id)
                .orElse(null);
        publisherRepo.deleteById(id);
    }
}
