package com.cinema.booking.service.impl;

import com.cinema.booking.entity.Show;
import com.cinema.booking.entity.Movie;
import com.cinema.booking.entity.Screen;
import com.cinema.booking.dto.shows.ShowRequestDto;
import com.cinema.booking.dto.shows.ShowResponseDto;
import com.cinema.booking.exception.ResourceNotFoundException;
import com.cinema.booking.mapper.ShowMapper;
import com.cinema.booking.repository.ShowRepository;
import com.cinema.booking.repository.MovieRepository;
import com.cinema.booking.repository.ScreenRepository;
import com.cinema.booking.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;
    private final ShowMapper showMapper;
    private final MovieRepository movieRepository;
    private final ScreenRepository screenRepository;

    @Override
    public ShowResponseDto create(ShowRequestDto dto) {
        Show show = showMapper.toEntity(dto);
        Movie movie = movieRepository.findById(dto.getMovieId())
                .orElseThrow(() -> new ResourceNotFoundException("Movie", dto.getMovieId()));
        show.setMovie(movie);
        Screen screen = screenRepository.findById(dto.getScreenId())
                .orElseThrow(() -> new ResourceNotFoundException("Screen", dto.getScreenId()));
        show.setScreen(screen);
        show = showRepository.save(show);
        return showMapper.toResponseDto(show);
    }

    @Override
    public ShowResponseDto update(Long id, ShowRequestDto dto) {
        Show existing = showRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Show", id));
        Show updated = showMapper.toEntity(dto);
        updated.setId(existing.getId());
        updated.setMovie(movieRepository.findById(dto.getMovieId())
                .orElseThrow(() -> new ResourceNotFoundException("Movie", dto.getMovieId())));
        updated.setScreen(screenRepository.findById(dto.getScreenId())
                .orElseThrow(() -> new ResourceNotFoundException("Screen", dto.getScreenId())));
        updated = showRepository.save(updated);
        return showMapper.toResponseDto(updated);
    }

    @Override
    public ShowResponseDto getById(Long id) {
        Show show = showRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Show", id));
        return showMapper.toResponseDto(show);
    }

    @Override
    public List<ShowResponseDto> getAll() {
        return showRepository.findAll().stream()
                .map(showMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!showRepository.existsById(id)) {
            throw new ResourceNotFoundException("Show", id);
        }
        showRepository.deleteById(id);
    }
}