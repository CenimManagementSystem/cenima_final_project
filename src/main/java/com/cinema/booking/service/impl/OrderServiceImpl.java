package com.cinema.booking.service.impl;

import com.cinema.booking.entity.Order;
import com.cinema.booking.entity.Booking;
import com.cinema.booking.entity.User;
import com.cinema.booking.dto.orders.OrderRequestDto;
import com.cinema.booking.dto.orders.OrderResponseDto;
import com.cinema.booking.exception.ResourceNotFoundException;
import com.cinema.booking.mapper.OrderMapper;
import com.cinema.booking.repository.OrderRepository;
import com.cinema.booking.repository.BookingRepository;
import com.cinema.booking.repository.UserRepository;
import com.cinema.booking.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;

    @Override
    public OrderResponseDto create(OrderRequestDto dto) {
        Order order = orderMapper.toEntity(dto);
        if (dto.getBookingId() != null) {
            Booking booking = bookingRepository.findById(dto.getBookingId())
                    .orElseThrow(() -> new ResourceNotFoundException("Booking", dto.getBookingId()));
            order.setBooking(booking);
        }
        User customer = userRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("User", dto.getCustomerId()));
        order.setCustomer(customer);
        order = orderRepository.save(order);
        return orderMapper.toResponseDto(order);
    }

    @Override
    public OrderResponseDto update(Long id, OrderRequestDto dto) {
        Order existing = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", id));
        Order updated = orderMapper.toEntity(dto);
        updated.setId(existing.getId());
        if (dto.getBookingId() != null) {
            updated.setBooking(bookingRepository.findById(dto.getBookingId())
                    .orElseThrow(() -> new ResourceNotFoundException("Booking", dto.getBookingId())));
        }
        updated.setCustomer(userRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("User", dto.getCustomerId())));
        updated = orderRepository.save(updated);
        return orderMapper.toResponseDto(updated);
    }

    @Override
    public OrderResponseDto getById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", id));
        return orderMapper.toResponseDto(order);
    }

    @Override
    public List<OrderResponseDto> getAll() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new ResourceNotFoundException("Order", id);
        }
        orderRepository.deleteById(id);
    }
}