package com.ijse.posbackend.controller;

import com.ijse.posbackend.entity.Category;
import com.ijse.posbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories(){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAllCategories());
    }

    @PostMapping("/categories")
    public ResponseEntity<?>  createCategory(@RequestBody Category category){

        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(category));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to Create the Category");
        }
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id){
        Category category = categoryService.findCategoryById(id);
        if(category != null){
            return ResponseEntity.status(HttpStatus.OK).body(category);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category Not Found");
        }

    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody Category category){

        try{
            return ResponseEntity.status(HttpStatus.OK).body(categoryService.updateCategory(id,category));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to Update the category");
        }

    }
}
