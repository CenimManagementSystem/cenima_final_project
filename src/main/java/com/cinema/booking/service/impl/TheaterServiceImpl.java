package com.cinema.booking.service.impl;

import com.cinema.booking.entity.Theater;
import com.cinema.booking.entity.Location;
import com.cinema.booking.entity.User;
import com.cinema.booking.dto.cinemas.TheaterRequestDto;
import com.cinema.booking.dto.cinemas.TheaterResponseDto;
import com.cinema.booking.exception.ResourceNotFoundException;
import com.cinema.booking.mapper.TheaterMapper;
import com.cinema.booking.repository.TheaterRepository;
import com.cinema.booking.repository.LocationRepository;
import com.cinema.booking.repository.UserRepository;
import com.cinema.booking.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository theaterRepository;
    private final TheaterMapper theaterMapper;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;

    @Override
    public TheaterResponseDto create(TheaterRequestDto dto) {
        Theater theater = theaterMapper.toEntity(dto);
        Location location = locationRepository.findById(dto.getLocationId())
                .orElseThrow(() -> new ResourceNotFoundException("Location", dto.getLocationId()));
        theater.setLocation(location);
        if (dto.getManagerId() != null) {
            User manager = userRepository.findById(dto.getManagerId())
                    .orElseThrow(() -> new ResourceNotFoundException("User", dto.getManagerId()));
            theater.setManager(manager);
        }
        theater = theaterRepository.save(theater);
        return theaterMapper.toResponseDto(theater);
    }

    @Override
    public TheaterResponseDto update(Long id, TheaterRequestDto dto) {
        Theater existing = theaterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Theater", id));
        Theater updated = theaterMapper.toEntity(dto);
        updated.setId(existing.getId());
        updated.setLocation(locationRepository.findById(dto.getLocationId())
                .orElseThrow(() -> new ResourceNotFoundException("Location", dto.getLocationId())));
        if (dto.getManagerId() != null) {
            updated.setManager(userRepository.findById(dto.getManagerId())
                    .orElseThrow(() -> new ResourceNotFoundException("User", dto.getManagerId())));
        }
        updated = theaterRepository.save(updated);
        return theaterMapper.toResponseDto(updated);
    }

    @Override
    public TheaterResponseDto getById(Long id) {
        Theater theater = theaterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Theater", id));
        return theaterMapper.toResponseDto(theater);
    }

    @Override
    public List<TheaterResponseDto> getAll() {
        return theaterRepository.findAll().stream()
                .map(theaterMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!theaterRepository.existsById(id)) {
            throw new ResourceNotFoundException("Theater", id);
        }
        theaterRepository.deleteById(id);
    }
}