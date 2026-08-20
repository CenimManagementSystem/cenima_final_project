package com.cinema.booking.service.impl;

import com.cinema.booking.entity.MovieCategory;
import com.cinema.booking.dto.category.CategoryRequestDto;
import com.cinema.booking.dto.category.CategoryResponseDto;
import com.cinema.booking.exception.ResourceNotFoundException;
import com.cinema.booking.mapper.CategoryMapper;
import com.cinema.booking.repository.MovieCategoryRepository;
import com.cinema.booking.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final MovieCategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponseDto create(CategoryRequestDto dto) {
        MovieCategory category = categoryMapper.toEntity(dto);
        category = categoryRepository.save(category);
        return categoryMapper.toResponseDto(category);
    }

    @Override
    public CategoryResponseDto update(Long id, CategoryRequestDto dto) {
        MovieCategory existing = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", id));
        MovieCategory updated = categoryMapper.toEntity(dto);
        updated.setId(existing.getId());
        updated = categoryRepository.save(updated);
        return categoryMapper.toResponseDto(updated);
    }

    @Override
    public CategoryResponseDto getById(Long id) {
        MovieCategory category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", id));
        return categoryMapper.toResponseDto(category);
    }

    @Override
    public List<CategoryResponseDto> getAll() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Category", id);
        }
        categoryRepository.deleteById(id);
    }
}
