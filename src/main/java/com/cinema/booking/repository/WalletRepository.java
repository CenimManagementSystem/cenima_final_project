package com.cinema.booking.repository;

import com.cinema.booking.entity.User;
import com.cinema.booking.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    boolean existsByUser(User user);
    Optional<Wallet> findByUser(User user);
}