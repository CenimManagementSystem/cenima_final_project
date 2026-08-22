package com.cinema.booking.repository;

import com.cinema.booking.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {
    boolean existsByName(String name);
    Optional<Theater> findByName(String name);
}