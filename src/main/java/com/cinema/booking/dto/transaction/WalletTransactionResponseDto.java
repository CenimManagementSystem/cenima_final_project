package com.cinema.booking.dto.transaction;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class WalletTransactionResponseDto {

    private Long id;

    private BigDecimal amount;
    private LocalDateTime createdAt;
    private String reference;
    private String status;
    private String transactionType;
    private Long bookingId;
    private Long orderId;
    private Long walletId;
}