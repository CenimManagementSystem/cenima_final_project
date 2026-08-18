package com.cinema.booking.mapper;

import com.cinema.booking.entity.Wallet;
import com.cinema.booking.dto.wallets.WalletRequestDto;
import com.cinema.booking.dto.wallets.WalletResponseDto;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {

    public Wallet toEntity(WalletRequestDto dto) {
        Wallet wallet = new Wallet();
        wallet.setBalance(dto.getBalance());
        wallet.setCurrency(dto.getCurrency());
        // TODO: FK fields (user) are resolved in the Service layer
        // using their respective repositories, then set on wallet before saving.
        return wallet;
    }

    public WalletResponseDto toResponseDto(Wallet wallet) {
        WalletResponseDto dto = new WalletResponseDto();
        dto.setId(wallet.getId());
        dto.setBalance(wallet.getBalance());
        dto.setCurrency(wallet.getCurrency());
        dto.setUserId(wallet.getUser() != null ? wallet.getUser().getId() : null);
        return dto;
    }
}