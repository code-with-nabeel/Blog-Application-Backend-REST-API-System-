package com.blog_app_apis.services;


import com.blog_app_apis.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto,Long categoryId);
    CategoryDto getCategoryById(Long categoryId);
    List<CategoryDto>getAllCategory();
    void deleteCategory(Long categoryId);
}
