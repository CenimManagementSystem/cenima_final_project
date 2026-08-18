package com.cinema.booking.dto.bookings;

import jakarta.validation.constraints.*;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BookingRequestDto {

    @NotNull

    private LocalDateTime bookedAt;
    @NotBlank
    private String bookingCode;
    @NotBlank
    private String status;
    @NotNull @Positive
    private BigDecimal totalAmount;
    @NotNull
    private Long customerId;
    @NotNull
    private Long showId;
}