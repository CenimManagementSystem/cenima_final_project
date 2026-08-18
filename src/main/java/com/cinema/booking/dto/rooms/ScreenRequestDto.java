package com.cinema.booking.dto.rooms;

import jakarta.validation.constraints.*;

import lombok.Data;

@Data
public class ScreenRequestDto {

    @NotBlank

    private String name;
    @NotBlank
    private String screenType;
    @NotBlank
    private String status;
    @NotNull @Min(1)
    private Integer totalSeats;
    @NotNull
    private Long theaterId;
}