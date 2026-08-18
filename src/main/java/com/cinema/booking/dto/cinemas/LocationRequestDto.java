package com.cinema.booking.dto.cinemas;

import jakarta.validation.constraints.*;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class LocationRequestDto {

    @NotBlank

    private String address;
    @NotBlank
    private String city;
    private String googleMapsUrl;
    @NotNull
    private BigDecimal latitude;
    @NotNull
    private BigDecimal longitude;
    @NotBlank
    private String name;
}