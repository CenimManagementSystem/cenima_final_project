package com.cinema.booking.dto.productcategories;

import lombok.Data;

@Data
public class ProductCategoryResponseDto {

    private Long id;

    private String description;
    private Boolean isActive;
    private String name;
}
