package com.cinema.booking.controller;

import com.cinema.booking.dto.transaction.WalletTransactionRequestDto;
import com.cinema.booking.dto.transaction.WalletTransactionResponseDto;
import com.cinema.booking.service.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/wallet-transactions")
@RequiredArgsConstructor
public class WalletTransactionController {

    private final WalletTransactionService walletTransactionService;

    @PostMapping
    public ResponseEntity<WalletTransactionResponseDto> create(@Valid @RequestBody WalletTransactionRequestDto dto) {
        return new ResponseEntity<>(walletTransactionService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WalletTransactionResponseDto> update(@PathVariable Long id, @Valid @RequestBody WalletTransactionRequestDto dto) {
        return ResponseEntity.ok(walletTransactionService.update(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WalletTransactionResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(walletTransactionService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<WalletTransactionResponseDto>> getAll() {
        return ResponseEntity.ok(walletTransactionService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        walletTransactionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}