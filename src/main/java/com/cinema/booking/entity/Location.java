package com.cinema.booking.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "locations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "city", nullable = true)
    private String city;

    @Column(name = "google_maps_url", nullable = true)
    private String googleMapsUrl;

    @Column(name = "latitude", nullable = true)
    private BigDecimal latitude;

    @Column(name = "longitude", nullable = true)
    private BigDecimal longitude;

    @Column(name = "name", nullable = false)
    private String name;

}