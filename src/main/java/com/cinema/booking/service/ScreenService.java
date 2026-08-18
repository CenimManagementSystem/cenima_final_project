package com.cinema.booking.service;

import com.cinema.booking.dto.rooms.ScreenRequestDto;
import com.cinema.booking.dto.rooms.ScreenResponseDto;
import java.util.List;

public interface ScreenService {

    ScreenResponseDto create(ScreenRequestDto dto);
    ScreenResponseDto update(Long id, ScreenRequestDto dto);
    ScreenResponseDto getById(Long id);
    List<ScreenResponseDto> getAll();
    void delete(Long id);
}