package com.cinema.booking.service.impl;

import com.cinema.booking.entity.Movie;
import com.cinema.booking.entity.MovieCategory;
import com.cinema.booking.dto.movies.MovieRequestDto;
import com.cinema.booking.dto.movies.MovieResponseDto;
import com.cinema.booking.exception.ResourceNotFoundException;
import com.cinema.booking.mapper.MovieMapper;
import com.cinema.booking.repository.MovieRepository;
import com.cinema.booking.repository.MovieCategoryRepository;
import com.cinema.booking.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    private final MovieCategoryRepository categoryRepository;

    @Override
    public MovieResponseDto create(MovieRequestDto dto) {
        Movie movie = movieMapper.toEntity(dto);
        if (dto.getMovieCategoryId() != null) {
            MovieCategory category = categoryRepository.findById(dto.getMovieCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Category", dto.getMovieCategoryId()));
            movie.setMovieCategory(category);
        }
        movie = movieRepository.save(movie);
        return movieMapper.toResponseDto(movie);
    }

    @Override
    public MovieResponseDto update(Long id, MovieRequestDto dto) {
        Movie existing = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie", id));
        Movie updated = movieMapper.toEntity(dto);
        updated.setId(existing.getId());
        if (dto.getMovieCategoryId() != null) {
            updated.setMovieCategory(categoryRepository.findById(dto.getMovieCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Category", dto.getMovieCategoryId())));
        }
        updated = movieRepository.save(updated);
        return movieMapper.toResponseDto(updated);
    }

    @Override
    public MovieResponseDto getById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie", id));
        return movieMapper.toResponseDto(movie);
    }

    @Override
    public List<MovieResponseDto> getAll() {
        return movieRepository.findAll().stream()
                .map(movieMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new ResourceNotFoundException("Movie", id);
        }
        movieRepository.deleteById(id);
    }
}