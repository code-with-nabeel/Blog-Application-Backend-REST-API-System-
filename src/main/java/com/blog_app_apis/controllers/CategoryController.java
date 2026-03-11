package com.blog_app_apis.controllers;


import com.blog_app_apis.payloads.CategoryDto;
import com.blog_app_apis.services.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    public final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto>createCategory(@Valid  @RequestBody CategoryDto categoryDto){
       return new ResponseEntity<>(categoryService.createCategory(categoryDto), HttpStatus.CREATED) ;
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto>updateCategory(@Valid @RequestBody CategoryDto categoryDto ,@PathVariable Long categoryId){
        return new ResponseEntity<>(categoryService.updateCategory(categoryDto,categoryId), HttpStatus.OK) ;
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto>getCategoryById(@PathVariable Long categoryId){
        return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>>getAllCategory(){
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<String>deleteUser(@PathVariable Long categoryId){
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Category deleted successfully");
    }


}
