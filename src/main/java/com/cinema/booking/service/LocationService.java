package com.cinema.booking.service;

import com.cinema.booking.dto.cinemas.LocationRequestDto;
import com.cinema.booking.dto.cinemas.LocationResponseDto;
import java.util.List;

public interface LocationService {

    LocationResponseDto create(LocationRequestDto dto);
    LocationResponseDto update(Long id, LocationRequestDto dto);
    LocationResponseDto getById(Long id);
    List<LocationResponseDto> getAll();
    void delete(Long id);
}