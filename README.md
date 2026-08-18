# Cinema Booking System — Backend Platform

A production-grade REST API backend for a comprehensive Cinema Booking and Ticketing System built with **Spring Boot 3**, **Java 21**, **Spring Security (JWT)**, and **MySQL**.

```
Client / Swagger UI → Spring Security (JWT) → Controller → Mapper → Service → Repository → MySQL
```

---

## Features

- **JWT Authentication & Authorization**: Stateless security filter chain with BCrypt password hashing and role-based access (`ROLE_USER`, `ROLE_ADMIN`).
- **Complete Domain Coverage (16 Entities + Auth)**:
  - User & Wallet management (`/api/users`, `/api/wallets`, `/api/wallet-transactions`)
  - Theaters, Locations, Screens & Seats (`/api/locations`, `/api/theaters`, `/api/screens`, `/api/seats`)
  - Movies & Show scheduling (`/api/movies`, `/api/shows`)
  - Ticketing & Seat Reservations (`/api/bookings`, `/api/booking-seats`)
  - Food & Beverage Concessions (`/api/categories`, `/api/products`, `/api/orders`, `/api/order-items`)
  - Payment records (`/api/payments`)
- **OpenAPI / Swagger UI**: Full interactive API documentation at `/swagger-ui/index.html` (or `/swagger-ui.html`).
- **Validation**: Strict request payload validation using `jakarta.validation` (`@Valid`, `@NotBlank`, `@NotNull`, `@Min`, `@Email`).
- **Centralized Error Handling**: Standardized error response structure for 400, 401, 403, 404 (`ResourceNotFoundException`), 409, and 500 status codes.

---

## Architectural Pattern

| Layer | Folder | Description |
|---|---|---|
| **Security** | `security/`, `config/` | JWT token filter, `UserDetailsService`, and SecurityFilterChain configuration |
| **Controller** | `controller/` | REST controllers routing HTTP requests and triggering payload validation |
| **DTO** | `dto/request/`, `dto/response/` | Flat data transfer objects preventing internal entity leakage |
| **Mapper** | `mapper/` | Pure scalar field copying between DTOs and Entities |
| **Service** | `service/`, `service/impl/` | Business logic, transactional boundaries, and foreign key resolution |
| **Repository** | `repository/` | Spring Data JPA interfaces (`JpaRepository<Entity, Long>`) |
| **Entity** | `entity/` | JPA `@Entity` domain models mapped to relational tables |
| **Util** | `util/` | Global constants (`AppConstants`) and `SecurityUtil` helpers |

---

## Getting Started

### Prerequisites
- **JDK 21**
- **MySQL 8.0+** (or Docker container)
- **Maven 3.8+** (or use included `./mvnw` / `mvnw.cmd`)

### Configuration
1. Configure database connection and JWT properties in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/movie_booking_system?useSSL=false&serverTimezone=UTC
   spring.datasource.username=root
   spring.datasource.password=root123
   jwt.secret=404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970
   jwt.expiration=86400000
   server.port=8081
   ```

2. Build and run tests:
   ```bash
   ./mvnw clean test
   ```

3. Start the application:
   ```bash
   ./mvnw spring-boot:run
   ```

4. Open Swagger UI:
   Navigate to `http://localhost:8081/swagger-ui/index.html` in your browser.

---

## API Documentation

- Detailed endpoint specifications: [APIEndpoint.md](APIEndpoint.md)
- Project architecture and directory structure: [Structure.md](Structure.md)
- Workflows and sequence diagrams: [SystemFlow.md](SystemFlow.md)
- Developer & Agent guidelines: [agent_guide.md](agent_guide.md)
