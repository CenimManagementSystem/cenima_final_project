package com.cinema.booking.dto.rooms;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class SeatResponseDto {

    private Long id;

    private BigDecimal price;
    private String rowName;
    private String seatNumber;
    private String seatType;
    private String status;
    private Long screenId;
}