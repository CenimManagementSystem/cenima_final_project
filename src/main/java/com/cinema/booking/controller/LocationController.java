package com.cinema.booking.controller;

import com.cinema.booking.dto.cinemas.LocationRequestDto;
import com.cinema.booking.dto.cinemas.LocationResponseDto;
import com.cinema.booking.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/locations")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @PostMapping
    public ResponseEntity<LocationResponseDto> create(@Valid @RequestBody LocationRequestDto dto) {
        return new ResponseEntity<>(locationService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocationResponseDto> update(@PathVariable Long id, @Valid @RequestBody LocationRequestDto dto) {
        return ResponseEntity.ok(locationService.update(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(locationService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<LocationResponseDto>> getAll() {
        return ResponseEntity.ok(locationService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        locationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}