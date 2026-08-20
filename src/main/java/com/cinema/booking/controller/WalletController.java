package com.cinema.booking.controller;

import com.cinema.booking.dto.wallets.WalletRequestDto;
import com.cinema.booking.dto.wallets.WalletResponseDto;
import com.cinema.booking.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/wallets")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @PostMapping
    public ResponseEntity<WalletResponseDto> create(@Valid @RequestBody WalletRequestDto dto) {
        return new ResponseEntity<>(walletService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WalletResponseDto> update(@PathVariable Long id, @Valid @RequestBody WalletRequestDto dto) {
        return ResponseEntity.ok(walletService.update(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WalletResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(walletService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<WalletResponseDto>> getAll() {
        return ResponseEntity.ok(walletService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        walletService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
