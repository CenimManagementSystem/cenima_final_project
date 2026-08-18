package com.cinema.booking.service;

import com.cinema.booking.dto.cinemas.TheaterRequestDto;
import com.cinema.booking.dto.cinemas.TheaterResponseDto;
import java.util.List;

public interface TheaterService {

    TheaterResponseDto create(TheaterRequestDto dto);
    TheaterResponseDto update(Long id, TheaterRequestDto dto);
    TheaterResponseDto getById(Long id);
    List<TheaterResponseDto> getAll();
    void delete(Long id);
}