package com.cinema.booking.mapper;

import com.cinema.booking.entity.Movie;
import com.cinema.booking.dto.movies.MovieRequestDto;
import com.cinema.booking.dto.movies.MovieResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public Movie toEntity(MovieRequestDto dto) {
        Movie movie = new Movie();
        movie.setAgeRating(dto.getAgeRating());
        movie.setDescription(dto.getDescription());
        movie.setDurationMinutes(dto.getDurationMinutes());
        movie.setGenre(dto.getGenre());
        movie.setLanguage(dto.getLanguage());
        movie.setPosterUrl(dto.getPosterUrl());
        movie.setReleaseDate(dto.getReleaseDate());
        movie.setStatus(dto.getStatus());
        movie.setTitle(dto.getTitle());
        return movie;
    }

    public MovieResponseDto toResponseDto(Movie movie) {
        MovieResponseDto dto = new MovieResponseDto();
        dto.setId(movie.getId());
        dto.setAgeRating(movie.getAgeRating());
        dto.setCategoryId(movie.getCategory() != null ? movie.getCategory().getId() : null);
        dto.setDescription(movie.getDescription());
        dto.setDurationMinutes(movie.getDurationMinutes());
        dto.setGenre(movie.getGenre());
        dto.setLanguage(movie.getLanguage());
        dto.setPosterUrl(movie.getPosterUrl());
        dto.setReleaseDate(movie.getReleaseDate());
        dto.setStatus(movie.getStatus());
        dto.setTitle(movie.getTitle());
        return dto;
    }
}