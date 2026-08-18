package com.cinema.booking.service.impl;

import com.cinema.booking.entity.OrderItem;
import com.cinema.booking.entity.Order;
import com.cinema.booking.entity.Product;
import com.cinema.booking.dto.orders.OrderItemRequestDto;
import com.cinema.booking.dto.orders.OrderItemResponseDto;
import com.cinema.booking.exception.ResourceNotFoundException;
import com.cinema.booking.mapper.OrderItemMapper;
import com.cinema.booking.repository.OrderItemRepository;
import com.cinema.booking.repository.OrderRepository;
import com.cinema.booking.repository.ProductRepository;
import com.cinema.booking.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    public OrderItemResponseDto create(OrderItemRequestDto dto) {
        OrderItem orderItem = orderItemMapper.toEntity(dto);
        Order order = orderRepository.findById(dto.getOrderId())
                .orElseThrow(() -> new ResourceNotFoundException("Order", dto.getOrderId()));
        orderItem.setOrder(order);
        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product", dto.getProductId()));
        orderItem.setProduct(product);
        orderItem = orderItemRepository.save(orderItem);
        return orderItemMapper.toResponseDto(orderItem);
    }

    @Override
    public OrderItemResponseDto update(Long id, OrderItemRequestDto dto) {
        OrderItem existing = orderItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrderItem", id));
        OrderItem updated = orderItemMapper.toEntity(dto);
        updated.setId(existing.getId());
        updated.setOrder(orderRepository.findById(dto.getOrderId())
                .orElseThrow(() -> new ResourceNotFoundException("Order", dto.getOrderId())));
        updated.setProduct(productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product", dto.getProductId())));
        updated = orderItemRepository.save(updated);
        return orderItemMapper.toResponseDto(updated);
    }

    @Override
    public OrderItemResponseDto getById(Long id) {
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrderItem", id));
        return orderItemMapper.toResponseDto(orderItem);
    }

    @Override
    public List<OrderItemResponseDto> getAll() {
        return orderItemRepository.findAll().stream()
                .map(orderItemMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!orderItemRepository.existsById(id)) {
            throw new ResourceNotFoundException("OrderItem", id);
        }
        orderItemRepository.deleteById(id);
    }
}