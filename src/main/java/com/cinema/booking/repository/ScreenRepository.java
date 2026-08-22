package com.cinema.booking.repository;

import com.cinema.booking.entity.Screen;
import com.cinema.booking.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Long> {
    boolean existsByNameAndTheater(String name, Theater theater);
    Optional<Screen> findByNameAndTheater(String name, Theater theater);
}