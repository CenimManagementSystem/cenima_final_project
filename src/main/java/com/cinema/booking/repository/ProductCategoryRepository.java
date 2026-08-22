package com.cinema.booking.repository;

import com.cinema.booking.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    boolean existsByName(String name);
    Optional<ProductCategory> findByName(String name);
}
