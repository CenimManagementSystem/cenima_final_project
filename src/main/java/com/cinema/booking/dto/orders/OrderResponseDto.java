package com.cinema.booking.dto.orders;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderResponseDto {

    private Long id;

    private LocalDateTime completedAt;
    private String orderNumber;
    private String orderType;
    private LocalDateTime orderedAt;
    private String status;
    private BigDecimal subtotal;
    private BigDecimal totalAmount;
    private Long bookingId;
    private Long customerId;
}