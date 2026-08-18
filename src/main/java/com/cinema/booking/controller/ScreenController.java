package com.cinema.booking.controller;

import com.cinema.booking.dto.rooms.ScreenRequestDto;
import com.cinema.booking.dto.rooms.ScreenResponseDto;
import com.cinema.booking.service.ScreenService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/screens")
@RequiredArgsConstructor
public class ScreenController {

    private final ScreenService screenService;

    @PostMapping
    public ResponseEntity<ScreenResponseDto> create(@Valid @RequestBody ScreenRequestDto dto) {
        return new ResponseEntity<>(screenService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScreenResponseDto> update(@PathVariable Long id, @Valid @RequestBody ScreenRequestDto dto) {
        return ResponseEntity.ok(screenService.update(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScreenResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(screenService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ScreenResponseDto>> getAll() {
        return ResponseEntity.ok(screenService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        screenService.delete(id);
        return ResponseEntity.noContent().build();
    }
}