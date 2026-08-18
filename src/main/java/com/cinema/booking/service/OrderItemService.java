package com.cinema.booking.service;

import com.cinema.booking.dto.orders.OrderItemRequestDto;
import com.cinema.booking.dto.orders.OrderItemResponseDto;
import java.util.List;

public interface OrderItemService {

    OrderItemResponseDto create(OrderItemRequestDto dto);
    OrderItemResponseDto update(Long id, OrderItemRequestDto dto);
    OrderItemResponseDto getById(Long id);
    List<OrderItemResponseDto> getAll();
    void delete(Long id);
}