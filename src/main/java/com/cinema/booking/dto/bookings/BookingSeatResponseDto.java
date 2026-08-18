package com.cinema.booking.dto.bookings;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class BookingSeatResponseDto {

    private Long id;

    private BigDecimal price;
    private String status;
    private Long bookingId;
    private Long seatId;
}