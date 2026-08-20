package com.cinema.booking.mapper;

import com.cinema.booking.entity.MovieCategory;
import com.cinema.booking.dto.category.CategoryRequestDto;
import com.cinema.booking.dto.category.CategoryResponseDto;

import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public MovieCategory toEntity(CategoryRequestDto dto) {
        MovieCategory category = new MovieCategory();
        category.setDescription(dto.getDescription());
        category.setIsActive(dto.getIsActive());
        category.setName(dto.getName());
        return category;
    }

    public CategoryResponseDto toResponseDto(MovieCategory category) {
        CategoryResponseDto dto = new CategoryResponseDto();
        dto.setId(category.getId());
        dto.setDescription(category.getDescription());
        dto.setIsActive(category.getIsActive());
        dto.setName(category.getName());
        return dto;
    }
}
