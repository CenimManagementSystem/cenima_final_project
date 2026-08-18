package com.cinema.booking.dto.wallets;

import jakarta.validation.constraints.*;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class WalletRequestDto {

    @NotNull

    private BigDecimal balance;
    @NotBlank
    private String currency;
    @NotNull
    private Long userId;
}