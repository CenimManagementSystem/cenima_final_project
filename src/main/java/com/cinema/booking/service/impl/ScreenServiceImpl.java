package com.cinema.booking.service.impl;

import com.cinema.booking.entity.Screen;
import com.cinema.booking.entity.Theater;
import com.cinema.booking.dto.rooms.ScreenRequestDto;
import com.cinema.booking.dto.rooms.ScreenResponseDto;
import com.cinema.booking.exception.ResourceNotFoundException;
import com.cinema.booking.mapper.ScreenMapper;
import com.cinema.booking.repository.ScreenRepository;
import com.cinema.booking.repository.TheaterRepository;
import com.cinema.booking.service.ScreenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScreenServiceImpl implements ScreenService {

    private final ScreenRepository screenRepository;
    private final ScreenMapper screenMapper;
    private final TheaterRepository theaterRepository;

    @Override
    public ScreenResponseDto create(ScreenRequestDto dto) {
        Screen screen = screenMapper.toEntity(dto);
        Long theaterId = Objects.requireNonNull(dto.getTheaterId(), "Theater ID must not be null");
        Theater theater = theaterRepository.findById(theaterId)
                .orElseThrow(() -> new ResourceNotFoundException("Theater", theaterId));
        screen.setTheater(theater);
        screen = screenRepository.save(screen);
        return screenMapper.toResponseDto(screen);
    }

    @Override
    public ScreenResponseDto update(Long id, ScreenRequestDto dto) {
        Long screenId = Objects.requireNonNull(id, "Screen ID must not be null");
        Screen existing = screenRepository.findById(screenId)
                .orElseThrow(() -> new ResourceNotFoundException("Screen", screenId));
        Screen updated = screenMapper.toEntity(dto);
        updated.setId(existing.getId());

        Long theaterId = Objects.requireNonNull(dto.getTheaterId(), "Theater ID must not be null");
        updated.setTheater(theaterRepository.findById(theaterId)
                .orElseThrow(() -> new ResourceNotFoundException("Theater", theaterId)));
        updated = screenRepository.save(updated);
        return screenMapper.toResponseDto(updated);
    }

    @Override
    public ScreenResponseDto getById(Long id) {
        Long screenId = Objects.requireNonNull(id, "Screen ID must not be null");
        Screen screen = screenRepository.findById(screenId)
                .orElseThrow(() -> new ResourceNotFoundException("Screen", screenId));
        return screenMapper.toResponseDto(screen);
    }

    @Override
    public List<ScreenResponseDto> getAll() {
        return screenRepository.findAll().stream()
                .map(screenMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        Long screenId = Objects.requireNonNull(id, "Screen ID must not be null");
        if (!screenRepository.existsById(screenId)) {
            throw new ResourceNotFoundException("Screen", screenId);
        }
        screenRepository.deleteById(screenId);
    }
}