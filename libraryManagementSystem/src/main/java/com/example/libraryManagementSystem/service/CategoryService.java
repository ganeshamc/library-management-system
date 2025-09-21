package com.example.libraryManagementSystem.service;

import com.example.libraryManagementSystem.entity.Author;
import com.example.libraryManagementSystem.entity.Category;
import com.example.libraryManagementSystem.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> getAllCategory(){
        return categoryRepo.findAll();
    }

    public Category getCategoryById(int id){
        return categoryRepo.findById(id)
                .orElse(null);
    }

    public Category saveOrUpdateCategory(Category category){
        return categoryRepo.save(category);
    }

    public void deleteCategoryById(int id){
        categoryRepo.findById(id)
                .orElse(null);
        categoryRepo.deleteById(id);
    }
}
