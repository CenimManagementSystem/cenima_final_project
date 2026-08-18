package com.cinema.booking.service;

import com.cinema.booking.dto.movies.MovieRequestDto;
import com.cinema.booking.dto.movies.MovieResponseDto;
import java.util.List;

public interface MovieService {

    MovieResponseDto create(MovieRequestDto dto);
    MovieResponseDto update(Long id, MovieRequestDto dto);
    MovieResponseDto getById(Long id);
    List<MovieResponseDto> getAll();
    void delete(Long id);
}