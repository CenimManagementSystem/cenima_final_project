package com.cinema.booking.service;

import com.cinema.booking.dto.category.CategoryRequestDto;
import com.cinema.booking.dto.category.CategoryResponseDto;

import java.util.List;

public interface CategoryService {

    CategoryResponseDto create(CategoryRequestDto dto);
    CategoryResponseDto update(Long id, CategoryRequestDto dto);
    CategoryResponseDto getById(Long id);
    List<CategoryResponseDto> getAll();
    void delete(Long id);
}