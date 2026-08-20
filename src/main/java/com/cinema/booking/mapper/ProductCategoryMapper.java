package com.cinema.booking.mapper;

import com.cinema.booking.entity.ProductCategory;
import com.cinema.booking.dto.productcategories.ProductCategoryRequestDto;
import com.cinema.booking.dto.productcategories.ProductCategoryResponseDto;

import org.springframework.stereotype.Component;

@Component
public class ProductCategoryMapper {

    public ProductCategory toEntity(ProductCategoryRequestDto dto) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setDescription(dto.getDescription());
        productCategory.setIsActive(dto.getIsActive());
        productCategory.setName(dto.getName());
        return productCategory;
    }

    public ProductCategoryResponseDto toResponseDto(ProductCategory productCategory) {
        ProductCategoryResponseDto dto = new ProductCategoryResponseDto();
        dto.setId(productCategory.getId());
        dto.setDescription(productCategory.getDescription());
        dto.setIsActive(productCategory.getIsActive());
        dto.setName(productCategory.getName());
        return dto;
    }
}
