package com.cinema.booking.dto.users;

import com.cinema.booking.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private Object id;
    private String username;
    private String email;
    private String role;
}