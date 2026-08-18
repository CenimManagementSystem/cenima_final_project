package com.cinema.booking.controller;

import com.cinema.booking.dto.orders.OrderItemRequestDto;
import com.cinema.booking.dto.orders.OrderItemResponseDto;
import com.cinema.booking.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/order-items")
@RequiredArgsConstructor
public class OrderItemController {

    private final OrderItemService orderItemService;

    @PostMapping
    public ResponseEntity<OrderItemResponseDto> create(@Valid @RequestBody OrderItemRequestDto dto) {
        return new ResponseEntity<>(orderItemService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItemResponseDto> update(@PathVariable Long id, @Valid @RequestBody OrderItemRequestDto dto) {
        return ResponseEntity.ok(orderItemService.update(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(orderItemService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<OrderItemResponseDto>> getAll() {
        return ResponseEntity.ok(orderItemService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderItemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}