package com.cinema.booking.repository;

import com.cinema.booking.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    boolean existsByName(String name);
    Optional<Location> findByName(String name);
}