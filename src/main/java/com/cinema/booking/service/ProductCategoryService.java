package com.cinema.booking.service;

import com.cinema.booking.dto.productcategories.ProductCategoryRequestDto;
import com.cinema.booking.dto.productcategories.ProductCategoryResponseDto;

import java.util.List;

public interface ProductCategoryService {

    ProductCategoryResponseDto create(ProductCategoryRequestDto dto);
    ProductCategoryResponseDto update(Long id, ProductCategoryRequestDto dto);
    ProductCategoryResponseDto getById(Long id);
    List<ProductCategoryResponseDto> getAll();
    void delete(Long id);
}
