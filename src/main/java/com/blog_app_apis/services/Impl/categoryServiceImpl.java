package com.blog_app_apis.services.Impl;

import com.blog_app_apis.entites.Category;
import com.blog_app_apis.exceptions.ResourceNotFoundException;
import com.blog_app_apis.mapper.CategoryMapper;
import com.blog_app_apis.payloads.CategoryDto;
import com.blog_app_apis.repositories.CategoryRepository;
import com.blog_app_apis.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class categoryServiceImpl implements CategoryService {

     private final CategoryRepository categoryRepository;
     private final CategoryMapper categoryMapper;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category=categoryMapper.toEntity(categoryDto);
        Category saveCategory=categoryRepository.save(category);
        return categoryMapper.toDto(saveCategory);
    }



    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId) {
        Category category=categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category" ,"id",categoryDto.getCategoryId()));
         Category updateCategory=categoryMapper.toEntity(categoryDto);
         updateCategory.setCategoryId(category.getCategoryId());
         Category saveCategory=categoryRepository.save(updateCategory);
        return categoryMapper.toDto(saveCategory);
    }


    @Override
    public CategoryDto getCategoryById(Long categoryId) {
        Category category=categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category" ,"id",categoryId));
        return categoryMapper.toDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> category=categoryRepository.findAll();
        return category.stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category=categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category" ,"id",categoryId));
        categoryRepository.delete(category);
    }
}
