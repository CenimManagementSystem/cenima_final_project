package com.cinema.booking.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = true)
    private MovieCategory category;

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

    @Column(name = "poster_public_id", nullable = true)
    private String posterPublicId;

    @Column(name = "release_date", nullable = true)
    private LocalDate releaseDate;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "title", nullable = false)
    private String title;
}