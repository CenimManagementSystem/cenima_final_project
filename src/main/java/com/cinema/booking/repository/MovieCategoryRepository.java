package com.cinema.booking.repository;

import com.cinema.booking.entity.MovieCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieCategoryRepository extends JpaRepository<MovieCategory, Long> {
    boolean existsByName(String name);
    Optional<MovieCategory> findByName(String name);
}
