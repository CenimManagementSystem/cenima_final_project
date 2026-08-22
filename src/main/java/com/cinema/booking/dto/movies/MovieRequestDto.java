package com.cinema.booking.dto.movies;

import jakarta.validation.constraints.*;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class MovieRequestDto {

    private Long movieCategoryId;
    private String description;
    
    @NotNull @Min(1)
    private Integer durationMinutes;
    
    @NotBlank
    private String genre;
    
    @NotBlank
    private String language;
    
    @NotBlank
    private String posterUrl;
    
    @NotNull
    private LocalDate releaseDate;
    
    @NotBlank
    private String status;
    
    @NotBlank
    private String title;

    @Min(1) @Max(10)
    private Double rating;

    @Positive
    private BigDecimal basePrice;

    private String director;
    private String cast;
    private String backdropUrl;
    private String trailerUrl;
}