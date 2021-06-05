package com.codewithcup.springboot.controller;

import com.codewithcup.springboot.model.examcontent.Category;
import com.codewithcup.springboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    //Add Category
    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody(required = false) Category category)throws Exception{
        Category category1 = categoryService.addCategory(category);
        return ResponseEntity.ok(category1);
    }

    //get Category By Id
    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId){
        return this.categoryService.getCategory(categoryId);
    }

    //get All Categories
    @GetMapping("/")
    public ResponseEntity<?> getAllCategories(){
        return ResponseEntity.ok(this.categoryService.getCategories());
    }

    //Update Category
    @PutMapping("/")
    public Category updateCategory(@RequestBody Category category){
        return this.categoryService.updateCategory(category);
    }

    //delete Category
    @DeleteMapping("/{categoryId}")
    public void deleteCategoryById(@PathVariable("categoryId") Long categoryId){
        this.categoryService.deleteCategory(categoryId);

    }
}
