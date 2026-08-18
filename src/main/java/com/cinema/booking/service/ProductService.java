package com.cinema.booking.service;

import com.cinema.booking.dto.products.ProductRequestDto;
import com.cinema.booking.dto.products.ProductResponseDto;
import java.util.List;

public interface ProductService {

    ProductResponseDto create(ProductRequestDto dto);
    ProductResponseDto update(Long id, ProductRequestDto dto);
    ProductResponseDto getById(Long id);
    List<ProductResponseDto> getAll();
    void delete(Long id);
}