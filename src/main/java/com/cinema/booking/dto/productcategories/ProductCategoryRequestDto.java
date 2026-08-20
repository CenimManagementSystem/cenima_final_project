package com.cinema.booking.dto.productcategories;

import jakarta.validation.constraints.*;

import lombok.Data;

@Data
public class ProductCategoryRequestDto {

    private String description;
    @NotNull
    private Boolean isActive;
    @NotBlank
    private String name;
}
