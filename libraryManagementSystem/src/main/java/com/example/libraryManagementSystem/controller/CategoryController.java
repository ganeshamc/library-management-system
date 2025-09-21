package com.example.libraryManagementSystem.controller;

import com.example.libraryManagementSystem.entity.Category;
import com.example.libraryManagementSystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> listCategory(){
        List<Category> category = categoryService.getAllCategory();
        return ResponseEntity.ok(category);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable int id){
        Category category = categoryService.getCategoryById(id);
        if(category == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        Category createdCategory = categoryService.saveOrUpdateCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category){
        Category existingCategory = categoryService.getCategoryById(id);
        if (existingCategory == null){
            ResponseEntity.notFound().build();
        }
        category.setId(id);
        categoryService.saveOrUpdateCategory(category);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id){
        Category book = categoryService.getCategoryById(id);
        if(book == null){
            return ResponseEntity.notFound().build();
        }
        categoryService.deleteCategoryById(id);
        return ResponseEntity.noContent().build();
    }
}
