package com.cinema.booking.repository;

import com.cinema.booking.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    boolean existsByTitle(String title);
    Optional<Movie> findByTitle(String title);
}