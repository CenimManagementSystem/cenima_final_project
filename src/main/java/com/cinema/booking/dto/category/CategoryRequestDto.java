package com.cinema.booking.dto.category;

import jakarta.validation.constraints.*;

import lombok.Data;

@Data
public class CategoryRequestDto {

    private String description;
    @NotNull
    private Boolean isActive;
    @NotBlank
    private String name;
}