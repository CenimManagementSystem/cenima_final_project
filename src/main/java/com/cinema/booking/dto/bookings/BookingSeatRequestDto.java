package com.cinema.booking.dto.bookings;

import jakarta.validation.constraints.*;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class BookingSeatRequestDto {

    @NotNull @Positive

    private BigDecimal price;
    @NotBlank
    private String status;
    @NotNull
    private Long bookingId;
    @NotNull
    private Long seatId;
}