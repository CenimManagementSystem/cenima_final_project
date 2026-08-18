package com.cinema.booking.mapper;

import com.cinema.booking.entity.Screen;
import com.cinema.booking.dto.rooms.ScreenRequestDto;
import com.cinema.booking.dto.rooms.ScreenResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ScreenMapper {

    public Screen toEntity(ScreenRequestDto dto) {
        Screen screen = new Screen();
        screen.setName(dto.getName());
        screen.setScreenType(dto.getScreenType());
        screen.setStatus(dto.getStatus());
        screen.setTotalSeats(dto.getTotalSeats());
        // TODO: FK fields (theater) are resolved in the Service layer
        // using their respective repositories, then set on screen before saving.
        return screen;
    }

    public ScreenResponseDto toResponseDto(Screen screen) {
        ScreenResponseDto dto = new ScreenResponseDto();
        dto.setId(screen.getId());
        dto.setName(screen.getName());
        dto.setScreenType(screen.getScreenType());
        dto.setStatus(screen.getStatus());
        dto.setTotalSeats(screen.getTotalSeats());
        dto.setTheaterId(screen.getTheater() != null ? screen.getTheater().getId() : null);
        return dto;
    }
}