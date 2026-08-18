package com.cinema.booking.service;

import com.cinema.booking.dto.rooms.SeatRequestDto;
import com.cinema.booking.dto.rooms.SeatResponseDto;
import java.util.List;

public interface SeatService {

    SeatResponseDto create(SeatRequestDto dto);
    SeatResponseDto update(Long id, SeatRequestDto dto);
    SeatResponseDto getById(Long id);
    List<SeatResponseDto> getAll();
    void delete(Long id);
}