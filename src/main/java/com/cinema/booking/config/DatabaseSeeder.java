package com.cinema.booking.config;

import com.cinema.booking.entity.User;
import com.cinema.booking.entity.ProductCategory;
import com.cinema.booking.enums.Role;
import com.cinema.booking.repository.UserRepository;
import com.cinema.booking.repository.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Profile("!test")
@RequiredArgsConstructor
@Slf4j
public class DatabaseSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        seedUserIfNotExists("admin", "admin@cinema.com", "Admin User", "Admin123", Role.ADMIN);
        seedUserIfNotExists("staff", "staff@cinema.com", "Staff Member", "Staff123", Role.STAFF);
        seedUserIfNotExists("user", "user@cinema.com", "Regular Customer", "User123", Role.USER);

        seedProductCategoryIfNotExists("Popcorn", "Freshly popped gourmet popcorn in sweet, salted, or cheese flavors", true);
        seedProductCategoryIfNotExists("Beverages", "Refreshing soft drinks, mineral water, and juices", true);
        seedProductCategoryIfNotExists("Snacks", "Delicious movie snacks including nachos, hot dogs, and candy", true);
        seedProductCategoryIfNotExists("Combos", "Value combos combining popcorn and beverages for the best experience", true);
    }

    private void seedUserIfNotExists(String username, String email, String name, String rawPassword, Role role) {
        if (!userRepository.existsByUsername(username) && !userRepository.existsByEmail(email)) {
            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setName(name);
            user.setPassword(passwordEncoder.encode(rawPassword));
            user.setRole(role);
            user.setStatus("ACTIVE");
            user.setCreatedAt(LocalDateTime.now());
            user.setUpdatedAt(LocalDateTime.now());

            userRepository.save(user);
            log.info("Default {} user created: username='{}', email='{}'", role, username, email);
        } else {
            log.debug("User with username='{}' or email='{}' already exists. Skipping.", username, email);
        }
    }

    private void seedProductCategoryIfNotExists(String name, String description, boolean isActive) {
        if (!productCategoryRepository.existsByName(name)) {
            ProductCategory category = new ProductCategory();
            category.setName(name);
            category.setDescription(description);
            category.setIsActive(isActive);

            productCategoryRepository.save(category);
            log.info("Default product category created: name='{}'", name);
        } else {
            log.debug("Product category with name='{}' already exists. Skipping.", name);
        }
    }
}
