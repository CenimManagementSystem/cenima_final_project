package com.cinema.booking.dto.wallets;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class WalletResponseDto {

    private Long id;

    private BigDecimal balance;
    private String currency;
    private Long userId;
}