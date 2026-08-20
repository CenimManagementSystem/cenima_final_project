package com.cinema.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinema.booking.entity.MovieCategory;

@Repository
public interface MovieCategoryRepository extends JpaRepository<MovieCategory, Long> {
}
