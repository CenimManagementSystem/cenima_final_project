package com.cinema.booking.service;

import com.cinema.booking.dto.transaction.WalletTransactionRequestDto;
import com.cinema.booking.dto.transaction.WalletTransactionResponseDto;

import java.util.List;

public interface WalletTransactionService {

    WalletTransactionResponseDto create(WalletTransactionRequestDto dto);
    WalletTransactionResponseDto update(Long id, WalletTransactionRequestDto dto);
    WalletTransactionResponseDto getById(Long id);
    List<WalletTransactionResponseDto> getAll();
    void delete(Long id);
}