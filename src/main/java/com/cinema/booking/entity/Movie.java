package com.cinema.booking.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "age_rating", nullable = true)
    private String ageRating;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "duration_minutes", nullable = false)
    private Integer durationMinutes;

    @Column(name = "genre", nullable = true)
    private String genre;

    @Column(name = "language", nullable = true)
    private String language;

    @Column(name = "poster_url", nullable = true)
    private String posterUrl;

    @Column(name = "release_date", nullable = true)
    private LocalDate releaseDate;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "title", nullable = false)
    private String title;

}