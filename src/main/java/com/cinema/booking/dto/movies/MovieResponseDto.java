package com.cinema.booking.dto.movies;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class MovieResponseDto {

    private Long id;
    private Long movieCategoryId;
    private String description;
    private Integer durationMinutes;
    private String genre;
    private String language;
    private String posterUrl;
    private String posterPublicId;
    private LocalDate releaseDate;
    private String status;
    private String title;
    private Double rating;
    private BigDecimal basePrice;
    private String director;
    private String cast;
    private String backdropUrl;
    private String trailerUrl;
}