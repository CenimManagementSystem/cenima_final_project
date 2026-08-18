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
public class RegisterResponseDto {
    private String message;
    private UserResponseDto user;
}
