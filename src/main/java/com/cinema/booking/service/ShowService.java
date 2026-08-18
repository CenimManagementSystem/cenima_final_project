package com.cinema.booking.service;

import com.cinema.booking.dto.shows.ShowRequestDto;
import com.cinema.booking.dto.shows.ShowResponseDto;
import java.util.List;

public interface ShowService {

    ShowResponseDto create(ShowRequestDto dto);
    ShowResponseDto update(Long id, ShowRequestDto dto);
    ShowResponseDto getById(Long id);
    List<ShowResponseDto> getAll();
    void delete(Long id);
}