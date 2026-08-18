package com.cinema.booking.dto.category;

import lombok.Data;

@Data
public class CategoryResponseDto {

    private Long id;

    private String description;
    private Boolean isActive;
    private String name;
}