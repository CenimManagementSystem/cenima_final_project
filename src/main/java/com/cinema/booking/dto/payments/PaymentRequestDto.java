package com.cinema.booking.dto.payments;

import jakarta.validation.constraints.*;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentRequestDto {

    @NotNull @Positive

    private BigDecimal amount;
    @NotNull
    private LocalDateTime paidAt;
    @NotBlank
    private String paymentMethod;
    @NotBlank
    private String status;
    @NotBlank
    private String transactionId;
    @NotNull
    private Long bookingId;
    @NotNull
    private Long customerId;
    @NotNull
    private Long orderId;
}