package com.cinema.booking.dto.rooms;

import jakarta.validation.constraints.*;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class SeatRequestDto {

    @NotNull @Positive

    private BigDecimal price;
    @NotBlank
    private String rowName;
    @NotBlank
    private String seatNumber;
    @NotBlank
    private String seatType;
    @NotBlank
    private String status;
    @NotNull
    private Long screenId;
}