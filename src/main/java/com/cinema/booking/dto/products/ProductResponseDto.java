package com.cinema.booking.dto.products;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductResponseDto {

    private Long id;

    private LocalDateTime createdAt;
    private String description;
    private String imageUrl;
    private Boolean isAvailable;
    private String name;
    private BigDecimal price;
    private Integer stockQuantity;
    private LocalDateTime updatedAt;
    private Long categoryId;
}