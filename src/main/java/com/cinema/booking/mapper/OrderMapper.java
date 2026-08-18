package com.cinema.booking.mapper;

import com.cinema.booking.entity.Order;
import com.cinema.booking.dto.orders.OrderRequestDto;
import com.cinema.booking.dto.orders.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order toEntity(OrderRequestDto dto) {
        Order order = new Order();
        order.setCompletedAt(dto.getCompletedAt());
        order.setOrderNumber(dto.getOrderNumber());
        order.setOrderType(dto.getOrderType());
        order.setOrderedAt(dto.getOrderedAt());
        order.setStatus(dto.getStatus());
        order.setSubtotal(dto.getSubtotal());
        order.setTotalAmount(dto.getTotalAmount());
        // TODO: FK fields (booking, customer) are resolved in the Service layer
        // using their respective repositories, then set on order before saving.
        return order;
    }

    public OrderResponseDto toResponseDto(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(order.getId());
        dto.setCompletedAt(order.getCompletedAt());
        dto.setOrderNumber(order.getOrderNumber());
        dto.setOrderType(order.getOrderType());
        dto.setOrderedAt(order.getOrderedAt());
        dto.setStatus(order.getStatus());
        dto.setSubtotal(order.getSubtotal());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setBookingId(order.getBooking() != null ? order.getBooking().getId() : null);
        dto.setCustomerId(order.getCustomer() != null ? order.getCustomer().getId() : null);
        return dto;
    }
}