package com.cinema.booking.dto.payments;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentResponseDto {

    private Long id;

    private BigDecimal amount;
    private LocalDateTime paidAt;
    private String paymentMethod;
    private String status;
    private String transactionId;
    private Long bookingId;
    private Long customerId;
    private Long orderId;
}