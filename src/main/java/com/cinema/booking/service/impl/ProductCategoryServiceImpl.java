package com.cinema.booking.service.impl;

import com.cinema.booking.entity.ProductCategory;
import com.cinema.booking.dto.productcategories.ProductCategoryRequestDto;
import com.cinema.booking.dto.productcategories.ProductCategoryResponseDto;
import com.cinema.booking.exception.ResourceNotFoundException;
import com.cinema.booking.mapper.ProductCategoryMapper;
import com.cinema.booking.repository.ProductCategoryRepository;
import com.cinema.booking.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;
    private final ProductCategoryMapper productCategoryMapper;

    @Override
    public ProductCategoryResponseDto create(ProductCategoryRequestDto dto) {
        ProductCategory productCategory = productCategoryMapper.toEntity(dto);
        productCategory = productCategoryRepository.save(productCategory);
        return productCategoryMapper.toResponseDto(productCategory);
    }

    @Override
    public ProductCategoryResponseDto update(Long id, ProductCategoryRequestDto dto) {
        ProductCategory existing = productCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProductCategory", id));
        ProductCategory updated = productCategoryMapper.toEntity(dto);
        updated.setId(existing.getId());
        updated = productCategoryRepository.save(updated);
        return productCategoryMapper.toResponseDto(updated);
    }

    @Override
    public ProductCategoryResponseDto getById(Long id) {
        ProductCategory productCategory = productCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProductCategory", id));
        return productCategoryMapper.toResponseDto(productCategory);
    }

    @Override
    public List<ProductCategoryResponseDto> getAll() {
        return productCategoryRepository.findAll().stream()
                .map(productCategoryMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!productCategoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("ProductCategory", id);
        }
        productCategoryRepository.deleteById(id);
    }
}
