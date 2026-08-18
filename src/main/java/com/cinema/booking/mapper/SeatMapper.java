package com.cinema.booking.mapper;

import com.cinema.booking.entity.Seat;
import com.cinema.booking.dto.rooms.SeatRequestDto;
import com.cinema.booking.dto.rooms.SeatResponseDto;
import org.springframework.stereotype.Component;

@Component
public class SeatMapper {

    public Seat toEntity(SeatRequestDto dto) {
        Seat seat = new Seat();
        seat.setPrice(dto.getPrice());
        seat.setRowName(dto.getRowName());
        seat.setSeatNumber(dto.getSeatNumber());
        seat.setSeatType(dto.getSeatType());
        seat.setStatus(dto.getStatus());
        // TODO: FK fields (screen) are resolved in the Service layer
        // using their respective repositories, then set on seat before saving.
        return seat;
    }

    public SeatResponseDto toResponseDto(Seat seat) {
        SeatResponseDto dto = new SeatResponseDto();
        dto.setId(seat.getId());
        dto.setPrice(seat.getPrice());
        dto.setRowName(seat.getRowName());
        dto.setSeatNumber(seat.getSeatNumber());
        dto.setSeatType(seat.getSeatType());
        dto.setStatus(seat.getStatus());
        dto.setScreenId(seat.getScreen() != null ? seat.getScreen().getId() : null);
        return dto;
    }
}