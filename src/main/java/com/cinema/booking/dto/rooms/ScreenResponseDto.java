package com.cinema.booking.dto.rooms;

import lombok.Data;

@Data
public class ScreenResponseDto {

    private Long id;

    private String name;
    private String screenType;
    private String status;
    private Integer totalSeats;
    private Long theaterId;
}