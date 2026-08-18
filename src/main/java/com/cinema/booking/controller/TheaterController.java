package com.cinema.booking.controller;

import com.cinema.booking.dto.cinemas.TheaterRequestDto;
import com.cinema.booking.dto.cinemas.TheaterResponseDto;
import com.cinema.booking.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/theaters")
@RequiredArgsConstructor
public class TheaterController {

    private final TheaterService theaterService;

    @PostMapping
    public ResponseEntity<TheaterResponseDto> create(@Valid @RequestBody TheaterRequestDto dto) {
        return new ResponseEntity<>(theaterService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TheaterResponseDto> update(@PathVariable Long id, @Valid @RequestBody TheaterRequestDto dto) {
        return ResponseEntity.ok(theaterService.update(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TheaterResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(theaterService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<TheaterResponseDto>> getAll() {
        return ResponseEntity.ok(theaterService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        theaterService.delete(id);
        return ResponseEntity.noContent().build();
    }
}