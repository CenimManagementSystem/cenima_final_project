package com.cinema.booking.repository;

import com.cinema.booking.entity.Screen;
import com.cinema.booking.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    boolean existsByScreenAndRowNameAndSeatNumber(Screen screen, String rowName, String seatNumber);
    long countByScreen(Screen screen);
}