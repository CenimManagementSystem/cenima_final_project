package com.cinema.booking.dto.users;

import com.cinema.booking.enums.Role;

import jakarta.validation.constraints.*;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserRequestDto {

    
    @NotBlank @Email
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    @NotNull
    private Role role;

    @NotBlank
    private String status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}