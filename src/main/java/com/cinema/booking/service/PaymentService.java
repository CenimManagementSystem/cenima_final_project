package com.cinema.booking.service;

import com.cinema.booking.dto.payments.PaymentRequestDto;
import com.cinema.booking.dto.payments.PaymentResponseDto;
import java.util.List;

public interface PaymentService {

    PaymentResponseDto create(PaymentRequestDto dto);
    PaymentResponseDto update(Long id, PaymentRequestDto dto);
    PaymentResponseDto getById(Long id);
    List<PaymentResponseDto> getAll();
    void delete(Long id);
}