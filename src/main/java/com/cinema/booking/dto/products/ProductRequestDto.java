package com.cinema.booking.dto.products;

import jakarta.validation.constraints.*;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductRequestDto {

    private LocalDateTime createdAt;
    private String description;
    private String imageUrl;
    @NotNull
    private Boolean isAvailable;
    @NotBlank
    private String name;
    @NotNull @Positive
    private BigDecimal price;
    @NotNull @Min(0)
    private Integer stockQuantity;
    private LocalDateTime updatedAt;
    @NotNull
    private Long categoryId;
}