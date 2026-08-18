package com.cinema.booking.dto.auth;

import com.cinema.booking.dto.users.UserResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponseDto {
    private String accessToken;
    private String tokenType;
    private long expiresIn;
    private UserResponseDto user;
}
