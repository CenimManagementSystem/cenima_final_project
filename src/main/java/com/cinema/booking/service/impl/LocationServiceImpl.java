package com.cinema.booking.service.impl;

import com.cinema.booking.entity.Location;
import com.cinema.booking.dto.cinemas.LocationRequestDto;
import com.cinema.booking.dto.cinemas.LocationResponseDto;
import com.cinema.booking.exception.ResourceNotFoundException;
import com.cinema.booking.mapper.LocationMapper;
import com.cinema.booking.repository.LocationRepository;
import com.cinema.booking.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    @Override
    public LocationResponseDto create(LocationRequestDto dto) {
        Location location = locationMapper.toEntity(dto);
        location = locationRepository.save(location);
        return locationMapper.toResponseDto(location);
    }

    @Override
    public LocationResponseDto update(Long id, LocationRequestDto dto) {
        Location existing = locationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Location", id));
        Location updated = locationMapper.toEntity(dto);
        updated.setId(existing.getId());
        updated = locationRepository.save(updated);
        return locationMapper.toResponseDto(updated);
    }

    @Override
    public LocationResponseDto getById(Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Location", id));
        return locationMapper.toResponseDto(location);
    }

    @Override
    public List<LocationResponseDto> getAll() {
        return locationRepository.findAll().stream()
                .map(locationMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!locationRepository.existsById(id)) {
            throw new ResourceNotFoundException("Location", id);
        }
        locationRepository.deleteById(id);
    }
}