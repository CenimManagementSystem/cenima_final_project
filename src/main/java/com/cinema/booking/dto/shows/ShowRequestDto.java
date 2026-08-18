package com.cinema.booking.dto.shows;

import jakarta.validation.constraints.*;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ShowRequestDto {

    @NotNull

    private LocalDateTime endTime;
    @NotNull
    private LocalDateTime startTime;
    @NotBlank
    private String status;
    @NotNull @Positive
    private BigDecimal ticketPrice;
    @NotNull
    private Long movieId;
    @NotNull
    private Long screenId;
}