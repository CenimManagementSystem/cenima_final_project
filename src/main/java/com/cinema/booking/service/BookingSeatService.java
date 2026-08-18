package com.cinema.booking.service;

import com.cinema.booking.dto.bookings.BookingSeatRequestDto;
import com.cinema.booking.dto.bookings.BookingSeatResponseDto;
import java.util.List;

public interface BookingSeatService {

    BookingSeatResponseDto create(BookingSeatRequestDto dto);
    BookingSeatResponseDto update(Long id, BookingSeatRequestDto dto);
    BookingSeatResponseDto getById(Long id);
    List<BookingSeatResponseDto> getAll();
    void delete(Long id);
}