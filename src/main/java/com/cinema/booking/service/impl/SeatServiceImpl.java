package com.cinema.booking.service.impl;

import com.cinema.booking.entity.Seat;
import com.cinema.booking.entity.Screen;
import com.cinema.booking.dto.rooms.SeatRequestDto;
import com.cinema.booking.dto.rooms.SeatResponseDto;
import com.cinema.booking.exception.ResourceNotFoundException;
import com.cinema.booking.mapper.SeatMapper;
import com.cinema.booking.repository.SeatRepository;
import com.cinema.booking.repository.ScreenRepository;
import com.cinema.booking.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;
    private final SeatMapper seatMapper;
    private final ScreenRepository screenRepository;

    @Override
    public SeatResponseDto create(SeatRequestDto dto) {
        Seat seat = seatMapper.toEntity(dto);
        Screen screen = screenRepository.findById(dto.getScreenId())
                .orElseThrow(() -> new ResourceNotFoundException("Screen", dto.getScreenId()));
        seat.setScreen(screen);
        seat = seatRepository.save(seat);
        return seatMapper.toResponseDto(seat);
    }

    @Override
    public SeatResponseDto update(Long id, SeatRequestDto dto) {
        Seat existing = seatRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seat", id));
        Seat updated = seatMapper.toEntity(dto);
        updated.setId(existing.getId());
        updated.setScreen(screenRepository.findById(dto.getScreenId())
                .orElseThrow(() -> new ResourceNotFoundException("Screen", dto.getScreenId())));
        updated = seatRepository.save(updated);
        return seatMapper.toResponseDto(updated);
    }

    @Override
    public SeatResponseDto getById(Long id) {
        Seat seat = seatRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seat", id));
        return seatMapper.toResponseDto(seat);
    }

    @Override
    public List<SeatResponseDto> getAll() {
        return seatRepository.findAll().stream()
                .map(seatMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!seatRepository.existsById(id)) {
            throw new ResourceNotFoundException("Seat", id);
        }
        seatRepository.deleteById(id);
    }
}