# Agent Guide — Cinema Movie Booking System Backend

This guide helps AI agents (and new developers) understand, build, and extend this
project. Read it before making changes.

## 1. What This Project Is

A backend REST API for a **cinema movie booking system**. Customers can:

- Browse movies and view shows
- Select seats for a show
- Book tickets
- Add food & beverages (popcorn, drinks, combos) to an order
- Pay via wallet or online gateway

Admins / theater managers can manage locations, theaters, screens, seats, movies, and shows.

> **Important current state:** the codebase is at its initial scaffold stage. The only
> runnable class is `CenimaProjectApplication`, and the source directories (`controller`,
> `service`, `repository`, `entity`, etc.) exist but contain only `.gitkeep` placeholders.
> `structure.md` documents the *target* architecture that should be implemented.

## 2. Tech Stack

| Concern | Choice |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 4.0.7 |
| Build | Maven (`mvnw`) |
| Persistence | Spring Data JPA |
| Databases | H2 (runtime, dev) + PostgreSQL (runtime, prod) |
| API docs | springdoc-openapi (Swagger UI) |
| Bean boilerplate | Lombok |
| Validation | spring-boot-starter-validation |
| IDs | UUID (`GenerationType.UUID`) |

## 3. Key Commands

Run these from the project root. Use the Maven wrapper (`./mvnw` on Linux/macOS, `mvnw.cmd` on Windows).

```bash
# Build
./mvnw clean compile

# Run tests
./mvnw test

# Run the app
./mvnw spring-boot:run

# Package
./mvnw clean package
```

- Tests live in `src/test/java` and use JUnit 5 + `@SpringBootTest`.
- After any change, run `./mvnw test` to verify nothing breaks.
- Swagger UI is available at `/swagger-ui.html` when the app is running.

## 4. Package Layout

Base package: `SpringInit_Project.project_etec.cenima_project`

```
src/main/java/SpringInit_Project/project_etec/cenima_project/
├── CenimaProjectApplication.java     # @SpringBootApplication entry point
├── config/                  # Security, CORS, OpenAPI, data seeding config
├── controller/              # REST endpoints (thin, no business logic)
├── dto/
│   ├── request/             # Inbound payloads (e.g. MovieRequest, BookingRequest)
│   └── response/            # Outbound payloads (e.g. MovieResponse, BookingResponse)
├── entity/                  # JPA entities mapped to DB tables
├── enums/                   # Enumerations (UserRole, BookingStatus, PaymentStatus, ...)
├── exception/               # Custom exceptions + global exception handler
├── mapper/                  # Entity <-> DTO converters (e.g. MovieMapper)
├── repository/              # Spring Data JPA repositories
└── service/                 # Business logic layer
```

Targeted entities (16 core tables):

```
users, locations, theaters, screens, seats, movies, shows,
bookings, booking_seats, product_categories, products, orders,
order_items, payments, wallets, wallet_transactions
```

## 5. Architecture & Layering Rules

Flow: `Controller -> Service -> Repository -> Database`

- **Controller** — HTTP routing, request/response mapping, validation annotations. No business logic.
- **Service** — business rules and transaction boundaries (`@Transactional`). Called by controllers.
- **Repository** — Spring Data JPA interfaces, no implementation code.
- **Mapper** — converts between `Entity` and `DTO` objects; keep it out of controllers/services when possible.
- **Entity** — JPA annotations only, no DTO fields.

Follow this layering when adding new features.

### API conventions

- REST endpoints under `/api/...` (e.g. `/api/bookings`).
- Use the controller names already planned in `structure.md`:
  `AuthController`, `MovieController`, `TheaterController`, `ScreenController`,
  `SeatController`, `ShowController`, `BookingController`, `ProductCategoryController`,
  `ProductController`, `OrderController`, `PaymentController`.
- IDs are UUIDs exposed as path variables: `@PathVariable UUID id`.

### Booking flow (core business transaction)

```
POST /api/bookings
  -> Validate customer
  -> Validate show
  -> Check seats (already booked -> error)
  -> Create booking
  -> Create booking seats
  -> Calculate ticket total
  -> Add food/drink order (optional, orders.booking_id nullable)
  -> Calculate order total
  -> Calculate grand total
  -> Create payment
  -> On success: confirm booking | on failure: cancel / payment failed
```

Wrap this in a single `@Transactional` service method so partial failures roll back.

### Order rules

- An order may be linked to a booking (`orders.booking_id = booking.id`) **or** stand
  alone for food-only purchases (`orders.booking_id = NULL`). Keep that column nullable.
- Order items reference products; products belong to product categories.

## 6. Database Notes

- Use **UUID** primary keys (`@GeneratedValue(strategy = GenerationType.UUID)`).
- Use `@Table(name = "...")` with plural snake_case table names to match the design docs
  (`movie_booking_system` schema).
- Relationships follow the flow docs in `*.md` files at the project root:
  - Cinema structure: `locations -> theaters -> screens -> seats`
  - Shows: `movies -> shows -> screens`
  - Bookings: `users -> bookings -> booking_seats -> seats`
  - F&B: `product_categories -> products -> order_items -> orders`
  - Payments: `bookings/orders -> payments -> wallets -> wallet_transactions`
- H2 is the default runtime DB for local dev; PostgreSQL is configured as the production
  runtime dependency. See `application.properties`.

## 7. Documentation Files (read before implementing)

Markdown flow docs at the project root describe intended behavior in detail:

| File | Contents |
|---|---|
| `structure.md` | Target package/file structure |
| `cinema_project_flow.md` | Full system spec: tables, relationships, flows, UUID strategy |
| `business_flow.md` | High-level entity overview |
| `CompleteSystem_flow.md` | Admin vs customer overview |
| `Customer_movie_booking_flow.md` | Customer booking journey |

## 8. Code Style & Conventions

- Java 21, standard formatting (tabs, as generated by Spring Initializr).
- Use Lombok (`@Getter`, `@Setter`, `@NoArgsConstructor`, `@Builder`, etc.) instead of
  hand-written accessors — it is configured as an annotation processor in `pom.xml`.
- DTOs for API input/output; never expose entities directly.
- Use `@Valid` + Jakarta Bean Validation annotations on request DTOs.
- Custom exceptions should be handled by a global `@RestControllerAdvice`.
- Do not add comments unless the code genuinely needs explanation.

## 9. Testing

- Unit tests use JUnit 5 (`spring-boot-starter-*-test` dependencies are already present).
- Follow the existing `CenimaProjectApplicationTests` pattern (`@SpringBootTest`) for integration
  tests and plain JUnit tests for service/mapper units.
- Run `./mvnw test` after changes.

## 10. Do's and Don'ts for Agents

**Do:**
- Keep controllers thin; put logic in services.
- Annotate service methods that write multiple records with `@Transactional`.
- Match table/entity/field naming to the flow docs.
- Use UUID IDs consistently end-to-end (entity -> repository -> service -> controller).
- Add validation to request DTOs and handle errors centrally.

**Don't:**
- Don't duplicate business logic across layers.
- Don't expose JPA entities directly in REST responses.
- Don't change the base package name (`SpringInit_Project.project_etec.cenima_project`) — tests and
  Spring component scanning depend on it.
- Don't commit secrets; keep DB credentials in environment variables / properties, not source.
