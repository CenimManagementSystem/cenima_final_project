package com.cinema.booking.service;

import com.cinema.booking.dto.wallets.WalletRequestDto;
import com.cinema.booking.dto.wallets.WalletResponseDto;
import java.util.List;

public interface WalletService {

    WalletResponseDto create(WalletRequestDto dto);
    WalletResponseDto update(Long id, WalletRequestDto dto);
    WalletResponseDto getById(Long id);
    List<WalletResponseDto> getAll();
    void delete(Long id);
}