package com.cinema.booking.dto.orders;

import jakarta.validation.constraints.*;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class OrderItemRequestDto {

    @NotNull @Min(1)

    private Integer quantity;
    @NotNull @Positive
    private BigDecimal subtotal;
    @NotNull @Positive
    private BigDecimal unitPrice;
    @NotNull
    private Long orderId;
    @NotNull
    private Long productId;
}