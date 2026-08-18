package com.cinema.booking.service;

import com.cinema.booking.dto.users.UserRequestDto;
import com.cinema.booking.dto.users.UserResponseDto;
import java.util.List;

public interface UserService {

    UserResponseDto create(UserRequestDto dto);
    UserResponseDto update(Long id, UserRequestDto dto);
    UserResponseDto getById(Long id);
    List<UserResponseDto> getAll();
    void delete(Long id);
}