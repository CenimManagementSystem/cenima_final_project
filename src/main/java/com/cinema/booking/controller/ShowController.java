package com.cinema.booking.controller;

import com.cinema.booking.dto.shows.ShowRequestDto;
import com.cinema.booking.dto.shows.ShowResponseDto;
import com.cinema.booking.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/shows")
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;

    @PostMapping
    public ResponseEntity<ShowResponseDto> create(@Valid @RequestBody ShowRequestDto dto) {
        return new ResponseEntity<>(showService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShowResponseDto> update(@PathVariable Long id, @Valid @RequestBody ShowRequestDto dto) {
        return ResponseEntity.ok(showService.update(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(showService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ShowResponseDto>> getAll() {
        return ResponseEntity.ok(showService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        showService.delete(id);
        return ResponseEntity.noContent().build();
    }
}