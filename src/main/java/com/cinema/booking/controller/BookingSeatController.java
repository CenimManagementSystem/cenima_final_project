package com.cinema.booking.controller;

import com.cinema.booking.dto.bookings.BookingSeatRequestDto;
import com.cinema.booking.dto.bookings.BookingSeatResponseDto;
import com.cinema.booking.service.BookingSeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/booking-seats")
@RequiredArgsConstructor
public class BookingSeatController {

    private final BookingSeatService bookingSeatService;

    @PostMapping
    public ResponseEntity<BookingSeatResponseDto> create(@Valid @RequestBody BookingSeatRequestDto dto) {
        return new ResponseEntity<>(bookingSeatService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingSeatResponseDto> update(@PathVariable Long id, @Valid @RequestBody BookingSeatRequestDto dto) {
        return ResponseEntity.ok(bookingSeatService.update(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingSeatResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(bookingSeatService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<BookingSeatResponseDto>> getAll() {
        return ResponseEntity.ok(bookingSeatService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookingSeatService.delete(id);
        return ResponseEntity.noContent().build();
    }
}