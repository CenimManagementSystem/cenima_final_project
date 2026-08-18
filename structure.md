# Project Architecture & Directory Structure

## 1. Directory Tree

```
cinema-booking-system/
├── .github/                      # GitHub configurations and workflows
├── .idea/                        # IDE workspace settings
├── src/
│   ├── main/
│   │   ├── java/com/cinema/booking/
│   │   │   ├── config/           # Security, Swagger/OpenAPI, and Web configuration
│   │   │   ├── controller/       # REST API endpoints and validation triggers
│   │   │   │   └── auth/         # Authentication endpoints (login, register)
│   │   │   ├── dto/              # Data Transfer Objects
│   │   │   │   ├── request/      # Input payload schemas with Jakarta Validation
│   │   │   │   └── response/     # Output response models
│   │   │   ├── entity/           # JPA Entities (mapped 1:1 with MySQL tables)
│   │   │   ├── enums/            # Domain enums (roles, statuses, types)
│   │   │   ├── exception/        # GlobalExceptionHandler & custom exception classes
│   │   │   ├── mapper/           # DTO ⇄ Entity conversion mappers
│   │   │   ├── repository/       # Spring Data JPA Repository interfaces
│   │   │   ├── security/         # JWT service, auth filter, and UserDetailsService
│   │   │   ├── service/          # Service layer interfaces
│   │   │   │   └── impl/         # Service implementations & business logic
│   │   │   ├── util/             # Application constants and security helper utilities
│   │   │   └── CinemaBookingSystemApplication.java
│   │   └── resources/
│   │       ├── application.properties # Spring Boot & DB configuration
│   │       ├── static/
│   │       └── templates/
│   └── test/
│       ├── java/com/cinema/booking/
│       │   └── controller/       # Controller integration & web tests
│       └── resources/            # Test-specific properties
├── Dockerfile                    # Containerization configuration
├── docker-compose.yml            # Local container orchestration
├── pom.xml                       # Maven dependencies & build plugins
├── mvnw / mvnw.cmd               # Cross-platform Maven wrappers
├── README.md                     # System documentation & setup guide
├── agent_guide.md                # Agent handbook & architectural constraints
├── APIEndpoint.md                # REST API endpoints reference
├── Structure.md                  # Project layout description
└── SystemFlow.md                 # Booking & system workflow diagrams
```

---

## 2. Layer Responsibilities

| Package / Layer | Primary Responsibility |
|---|---|
| **`config`** | Spring Security filter chains, CORS policies, Swagger/OpenAPI specifications, and password encoders. |
| **`controller`** | HTTP request routing, input validation (`@Valid`), HTTP status codes (`200`, `201`, `204`). |
| **`dto`** | Decouples internal database entities from external API contracts. |
| **`entity`** | Hibernate/JPA object relational mapping to database tables. |
| **`mapper`** | Converts scalar properties between DTOs and Entities without database dependencies. |
| **`repository`** | Data access layer extending `JpaRepository` with standard CRUD and query derivation. |
| **`security`** | JWT generation/parsing, Bearer token filtering, and Spring Security authentication integration. |
| **`service`** | Business rules, foreign key resolution, transactional management, and entity orchestration. |
| **`util`** | Cross-cutting helper functions, constant definitions, and security context utilities. |
| **`exception`** | Centralized error formatting via `@RestControllerAdvice` and domain-specific exceptions. |
