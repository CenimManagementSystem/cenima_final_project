package com.cinema.booking.mapper;

import com.cinema.booking.entity.Category;
import com.cinema.booking.dto.category.CategoryRequestDto;
import com.cinema.booking.dto.category.CategoryResponseDto;

import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryRequestDto dto) {
        Category category = new Category();
        category.setDescription(dto.getDescription());
        category.setIsActive(dto.getIsActive());
        category.setName(dto.getName());
        return category;
    }

    public CategoryResponseDto toResponseDto(Category category) {
        CategoryResponseDto dto = new CategoryResponseDto();
        dto.setId(category.getId());
        dto.setDescription(category.getDescription());
        dto.setIsActive(category.getIsActive());
        dto.setName(category.getName());
        return dto;
    }
}
