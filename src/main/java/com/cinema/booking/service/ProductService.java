package com.cinema.booking.service;

import com.cinema.booking.dto.products.ProductRequestDto;
import com.cinema.booking.dto.products.ProductResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    ProductResponseDto create(ProductRequestDto dto, MultipartFile image);
    ProductResponseDto update(Long id, ProductRequestDto dto, MultipartFile image);
    ProductResponseDto getById(Long id);
    List<ProductResponseDto> getAll();
    void delete(Long id);
}