package com.cinema.booking.dto.movies;

import lombok.Data;
import java.time.LocalDate;

@Data
public class MovieResponseDto {

    private Long id;
    private Long categoryId;
    private String description;
    private Integer durationMinutes;
    private String genre;
    private String language;
    private String posterUrl;
    private String posterPublicId;
    private LocalDate releaseDate;
    private String status;
    private String title;
}