package com.cinema.booking.service;

import com.cinema.booking.dto.orders.OrderRequestDto;
import com.cinema.booking.dto.orders.OrderResponseDto;
import java.util.List;

public interface OrderService {

    OrderResponseDto create(OrderRequestDto dto);
    OrderResponseDto update(Long id, OrderRequestDto dto);
    OrderResponseDto getById(Long id);
    List<OrderResponseDto> getAll();
    void delete(Long id);
}