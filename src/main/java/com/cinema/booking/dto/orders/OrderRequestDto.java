package com.cinema.booking.dto.orders;

import jakarta.validation.constraints.*;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderRequestDto {

    @NotNull

    private LocalDateTime completedAt;
    @NotBlank
    private String orderNumber;
    @NotBlank
    private String orderType;
    @NotNull
    private LocalDateTime orderedAt;
    @NotBlank
    private String status;
    @NotNull @Positive
    private BigDecimal subtotal;
    @NotNull @Positive
    private BigDecimal totalAmount;
    @NotNull
    private Long bookingId;
    @NotNull
    private Long customerId;
}