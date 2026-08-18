package com.cinema.booking.service.impl;

import com.cinema.booking.entity.WalletTransaction;
import com.cinema.booking.entity.Booking;
import com.cinema.booking.entity.Order;
import com.cinema.booking.entity.Wallet;
import com.cinema.booking.dto.transaction.WalletTransactionRequestDto;
import com.cinema.booking.dto.transaction.WalletTransactionResponseDto;
import com.cinema.booking.exception.ResourceNotFoundException;
import com.cinema.booking.mapper.WalletTransactionMapper;
import com.cinema.booking.repository.WalletTransactionRepository;
import com.cinema.booking.repository.BookingRepository;
import com.cinema.booking.repository.OrderRepository;
import com.cinema.booking.repository.WalletRepository;
import com.cinema.booking.service.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WalletTransactionServiceImpl implements WalletTransactionService {

    private final WalletTransactionRepository walletTransactionRepository;
    private final WalletTransactionMapper walletTransactionMapper;
    private final BookingRepository bookingRepository;
    private final OrderRepository orderRepository;
    private final WalletRepository walletRepository;

    @Override
    public WalletTransactionResponseDto create(WalletTransactionRequestDto dto) {
        WalletTransaction walletTransaction = walletTransactionMapper.toEntity(dto);
        if (dto.getBookingId() != null) {
            Booking booking = bookingRepository.findById(dto.getBookingId())
                    .orElseThrow(() -> new ResourceNotFoundException("Booking", dto.getBookingId()));
            walletTransaction.setBooking(booking);
        }
        if (dto.getOrderId() != null) {
            Order order = orderRepository.findById(dto.getOrderId())
                    .orElseThrow(() -> new ResourceNotFoundException("Order", dto.getOrderId()));
            walletTransaction.setOrder(order);
        }
        Wallet wallet = walletRepository.findById(dto.getWalletId())
                .orElseThrow(() -> new ResourceNotFoundException("Wallet", dto.getWalletId()));
        walletTransaction.setWallet(wallet);
        walletTransaction = walletTransactionRepository.save(walletTransaction);
        return walletTransactionMapper.toResponseDto(walletTransaction);
    }

    @Override
    public WalletTransactionResponseDto update(Long id, WalletTransactionRequestDto dto) {
        WalletTransaction existing = walletTransactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WalletTransaction", id));
        WalletTransaction updated = walletTransactionMapper.toEntity(dto);
        updated.setId(existing.getId());
        if (dto.getBookingId() != null) {
            updated.setBooking(bookingRepository.findById(dto.getBookingId())
                    .orElseThrow(() -> new ResourceNotFoundException("Booking", dto.getBookingId())));
        }
        if (dto.getOrderId() != null) {
            updated.setOrder(orderRepository.findById(dto.getOrderId())
                    .orElseThrow(() -> new ResourceNotFoundException("Order", dto.getOrderId())));
        }
        updated.setWallet(walletRepository.findById(dto.getWalletId())
                .orElseThrow(() -> new ResourceNotFoundException("Wallet", dto.getWalletId())));
        updated = walletTransactionRepository.save(updated);
        return walletTransactionMapper.toResponseDto(updated);
    }

    @Override
    public WalletTransactionResponseDto getById(Long id) {
        WalletTransaction walletTransaction = walletTransactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WalletTransaction", id));
        return walletTransactionMapper.toResponseDto(walletTransaction);
    }

    @Override
    public List<WalletTransactionResponseDto> getAll() {
        return walletTransactionRepository.findAll().stream()
                .map(walletTransactionMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!walletTransactionRepository.existsById(id)) {
            throw new ResourceNotFoundException("WalletTransaction", id);
        }
        walletTransactionRepository.deleteById(id);
    }
}