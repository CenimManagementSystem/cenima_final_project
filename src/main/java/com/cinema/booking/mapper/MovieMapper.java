package com.cinema.booking.mapper;

import com.cinema.booking.entity.Movie;
import com.cinema.booking.dto.movies.MovieRequestDto;
import com.cinema.booking.dto.movies.MovieResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public Movie toEntity(MovieRequestDto dto) {
        Movie movie = new Movie();
        movie.setDescription(dto.getDescription());
        movie.setDurationMinutes(dto.getDurationMinutes());
        movie.setGenre(dto.getGenre());
        movie.setLanguage(dto.getLanguage());
        movie.setPosterUrl(dto.getPosterUrl());
        movie.setReleaseDate(dto.getReleaseDate());
        movie.setStatus(dto.getStatus());
        movie.setTitle(dto.getTitle());
        movie.setRating(dto.getRating());
        movie.setBasePrice(dto.getBasePrice());
        movie.setDirector(dto.getDirector());
        movie.setCast(dto.getCast());
        movie.setBackdropUrl(dto.getBackdropUrl());
        movie.setTrailerUrl(dto.getTrailerUrl());
        return movie;
    }

    public MovieResponseDto toResponseDto(Movie movie) {
        MovieResponseDto dto = new MovieResponseDto();
        dto.setId(movie.getId());
        dto.setMovieCategoryId(movie.getMovieCategory() != null ? movie.getMovieCategory().getId() : null);
        dto.setDescription(movie.getDescription());
        dto.setDurationMinutes(movie.getDurationMinutes());
        dto.setGenre(movie.getGenre());
        dto.setLanguage(movie.getLanguage());
        dto.setPosterUrl(movie.getPosterUrl());
        dto.setPosterPublicId(movie.getPosterPublicId());
        dto.setReleaseDate(movie.getReleaseDate());
        dto.setStatus(movie.getStatus());
        dto.setTitle(movie.getTitle());
        dto.setRating(movie.getRating());
        dto.setBasePrice(movie.getBasePrice());
        dto.setDirector(movie.getDirector());
        dto.setCast(movie.getCast());
        dto.setBackdropUrl(movie.getBackdropUrl());
        dto.setTrailerUrl(movie.getTrailerUrl());
        return dto;
    }
}