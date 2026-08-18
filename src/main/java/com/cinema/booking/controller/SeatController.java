package com.cinema.booking.controller;

import com.cinema.booking.dto.rooms.SeatRequestDto;
import com.cinema.booking.dto.rooms.SeatResponseDto;
import com.cinema.booking.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/seats")
@RequiredArgsConstructor
public class SeatController {

    private final SeatService seatService;

    @PostMapping
    public ResponseEntity<SeatResponseDto> create(@Valid @RequestBody SeatRequestDto dto) {
        return new ResponseEntity<>(seatService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeatResponseDto> update(@PathVariable Long id, @Valid @RequestBody SeatRequestDto dto) {
        return ResponseEntity.ok(seatService.update(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeatResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(seatService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<SeatResponseDto>> getAll() {
        return ResponseEntity.ok(seatService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        seatService.delete(id);
        return ResponseEntity.noContent().build();
    }
}