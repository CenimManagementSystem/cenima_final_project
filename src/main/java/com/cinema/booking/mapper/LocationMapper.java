package com.cinema.booking.mapper;

import com.cinema.booking.entity.Location;
import com.cinema.booking.dto.cinemas.LocationRequestDto;
import com.cinema.booking.dto.cinemas.LocationResponseDto;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {

    public Location toEntity(LocationRequestDto dto) {
        Location location = new Location();
        location.setAddress(dto.getAddress());
        location.setCity(dto.getCity());
        location.setGoogleMapsUrl(dto.getGoogleMapsUrl());
        location.setLatitude(dto.getLatitude());
        location.setLongitude(dto.getLongitude());
        location.setName(dto.getName());
        return location;
    }

    public LocationResponseDto toResponseDto(Location location) {
        LocationResponseDto dto = new LocationResponseDto();
        dto.setId(location.getId());
        dto.setAddress(location.getAddress());
        dto.setCity(location.getCity());
        dto.setGoogleMapsUrl(location.getGoogleMapsUrl());
        dto.setLatitude(location.getLatitude());
        dto.setLongitude(location.getLongitude());
        dto.setName(location.getName());
        return dto;
    }
}