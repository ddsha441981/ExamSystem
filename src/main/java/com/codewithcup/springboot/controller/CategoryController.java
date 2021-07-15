package com.codewithcup.springboot.controller;

import com.codewithcup.springboot.model.examcontent.Category;
import com.codewithcup.springboot.service.CategoryService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
    private static final Log logger = LogFactory.getLog(CategoryController.class);
    @Autowired
    private CategoryService categoryService;
    //Add Category
    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody(required = false) Category category){
        Category categoryObj = null;
        try{
            categoryObj = categoryService.addCategory(category);
            return ResponseEntity.ok().body(categoryObj);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    //get Category By Id
    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getCategory(@PathVariable("categoryId") Long categoryId){
        try{
            Category cateById = this.categoryService.getCategory(categoryId);
            if(cateById == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.of(Optional.of(cateById));

        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
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
