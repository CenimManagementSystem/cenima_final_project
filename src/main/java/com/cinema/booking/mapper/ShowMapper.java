package com.cinema.booking.mapper;

import com.cinema.booking.entity.Show;
import com.cinema.booking.dto.shows.ShowRequestDto;
import com.cinema.booking.dto.shows.ShowResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ShowMapper {

    public Show toEntity(ShowRequestDto dto) {
        Show show = new Show();
        show.setEndTime(dto.getEndTime());
        show.setStartTime(dto.getStartTime());
        show.setStatus(dto.getStatus());
        show.setTicketPrice(dto.getTicketPrice());
        // TODO: FK fields (movie, screen) are resolved in the Service layer
        // using their respective repositories, then set on show before saving.
        return show;
    }

    public ShowResponseDto toResponseDto(Show show) {
        ShowResponseDto dto = new ShowResponseDto();
        dto.setId(show.getId());
        dto.setEndTime(show.getEndTime());
        dto.setStartTime(show.getStartTime());
        dto.setStatus(show.getStatus());
        dto.setTicketPrice(show.getTicketPrice());
        dto.setMovieId(show.getMovie() != null ? show.getMovie().getId() : null);
        dto.setScreenId(show.getScreen() != null ? show.getScreen().getId() : null);
        return dto;
    }
}