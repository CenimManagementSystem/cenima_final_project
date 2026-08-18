package com.cinema.booking.dto.shows;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ShowResponseDto {

    private Long id;

    private LocalDateTime endTime;
    private LocalDateTime startTime;
    private String status;
    private BigDecimal ticketPrice;
    private Long movieId;
    private Long screenId;
}