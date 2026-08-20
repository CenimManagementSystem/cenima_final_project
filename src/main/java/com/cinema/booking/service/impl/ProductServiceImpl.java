package com.cinema.booking.service.impl;

import com.cinema.booking.entity.Product;
import com.cinema.booking.entity.ProductCategory;
import com.cinema.booking.dto.products.ProductRequestDto;
import com.cinema.booking.dto.products.ProductResponseDto;
import com.cinema.booking.exception.ResourceNotFoundException;
import com.cinema.booking.mapper.ProductMapper;
import com.cinema.booking.repository.ProductRepository;
import com.cinema.booking.repository.ProductCategoryRepository;
import com.cinema.booking.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductResponseDto create(ProductRequestDto dto) {
        Product product = productMapper.toEntity(dto);
        ProductCategory productCategory = productCategoryRepository.findById(dto.getProductCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("ProductCategory", dto.getProductCategoryId()));
        product.setProductCategory(productCategory);
        product = productRepository.save(product);
        return productMapper.toResponseDto(product);
    }

    @Override
    public ProductResponseDto update(Long id, ProductRequestDto dto) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", id));
        Product updated = productMapper.toEntity(dto);
        updated.setId(existing.getId());
        updated.setProductCategory(productCategoryRepository.findById(dto.getProductCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("ProductCategory", dto.getProductCategoryId())));
        updated = productRepository.save(updated);
        return productMapper.toResponseDto(updated);
    }

    @Override
    public ProductResponseDto getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", id));
        return productMapper.toResponseDto(product);
    }

    @Override
    public List<ProductResponseDto> getAll() {
        return productRepository.findAll().stream()
                .map(productMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product", id);
        }
        productRepository.deleteById(id);
    }
}