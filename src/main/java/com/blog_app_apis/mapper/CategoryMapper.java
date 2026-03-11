package com.blog_app_apis.mapper;

import com.blog_app_apis.entites.Category;
import com.blog_app_apis.payloads.CategoryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto toDto(Category category);
    Category toEntity(CategoryDto categoryDto);
}
