package com.cinema.booking.service.impl;

import com.cinema.booking.entity.Wallet;
import com.cinema.booking.entity.User;
import com.cinema.booking.dto.wallets.WalletRequestDto;
import com.cinema.booking.dto.wallets.WalletResponseDto;
import com.cinema.booking.exception.ResourceNotFoundException;
import com.cinema.booking.mapper.WalletMapper;
import com.cinema.booking.repository.WalletRepository;
import com.cinema.booking.repository.UserRepository;
import com.cinema.booking.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;
    private final WalletMapper walletMapper;
    private final UserRepository userRepository;

    @Override
    public WalletResponseDto create(WalletRequestDto dto) {
        Wallet wallet = walletMapper.toEntity(dto);
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User", dto.getUserId()));
        wallet.setUser(user);
        wallet = walletRepository.save(wallet);
        return walletMapper.toResponseDto(wallet);
    }

    @Override
    public WalletResponseDto update(Long id, WalletRequestDto dto) {
        Wallet existing = walletRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet", id));
        Wallet updated = walletMapper.toEntity(dto);
        updated.setId(existing.getId());
        updated.setUser(userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User", dto.getUserId())));
        updated = walletRepository.save(updated);
        return walletMapper.toResponseDto(updated);
    }

    @Override
    public WalletResponseDto getById(Long id) {
        Wallet wallet = walletRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet", id));
        return walletMapper.toResponseDto(wallet);
    }

    @Override
    public List<WalletResponseDto> getAll() {
        return walletRepository.findAll().stream()
                .map(walletMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!walletRepository.existsById(id)) {
            throw new ResourceNotFoundException("Wallet", id);
        }
        walletRepository.deleteById(id);
    }
}