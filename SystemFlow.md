# Cinema Booking System — Workflows & Architecture

This document describes the operational workflows for Customers and Administrators, including sequence diagrams.

---

## 1. Customer Booking Workflow

```mermaid
sequenceDiagram
    autonumber
    actor Customer
    participant Auth as Auth Controller (/api/auth)
    participant Show as Shows & Seats (/api/shows, /api/seats)
    participant Booking as Booking Service (/api/bookings)
    participant Payment as Payment & Wallet (/api/payments, /api/wallets)

    Customer->>Auth: POST /api/auth/login
    Auth-->>Customer: Return JWT Bearer Token

    Customer->>Show: GET /api/movies & /api/shows
    Show-->>Customer: Available Movies & Showtimes

    Customer->>Show: GET /api/screens/{id} & /api/seats
    Show-->>Customer: Screen layout & available seats

    Customer->>Booking: POST /api/bookings (Create booking + seats)
    Booking-->>Customer: Booking Created (Status: PENDING)

    Customer->>Payment: POST /api/payments (Wallet deduction or Gateway)
    Payment-->>Booking: Confirm Payment
    Booking-->>Customer: Booking Confirmed (Status: CONFIRMED)
```

---

## 2. Customer Detailed Steps

1. **Authentication:**
   - User registers via `/api/auth/register` or logs in via `/api/auth/login`.
   - Client stores the returned JWT token and attaches it as `Authorization: Bearer <token>` on all requests.
2. **Movie & Showtime Selection:**
   - Query active movies (`/api/movies`).
   - Find scheduled shows by theater, screen, and time (`/api/shows`).
3. **Seat Selection:**
   - Fetch screen details (`/api/screens/{id}`) and seat map (`/api/seats`).
   - Verify available seats for the designated show.
4. **Booking & Seat Lock:**
   - Submit booking request (`/api/bookings`) with customer and show IDs.
   - Associate reserved seats (`/api/booking-seats`).
5. **Concessions & Orders (Optional):**
   - Browse snack/drink categories (`/api/categories`, `/api/products`).
   - Place food order (`/api/orders`, `/api/order-items`).
6. **Payment Processing:**
   - Execute payment through wallet balance (`/api/wallets`, `/api/wallet-transactions`) or direct payment record (`/api/payments`).
   - Booking status updates to `CONFIRMED`.

---

## 3. Administrator Workflow

```mermaid
flowchart TD
    A[Admin Login] --> B[Manage Master Data]
    B --> C[Locations & Theaters]
    B --> D[Screens & Seat Layouts]
    B --> E[Movie Catalog]
    B --> F[Food & Concession Items]
    
    C --> G[Schedule Showtimes]
    D --> G
    E --> G
    
    G --> H[Monitor Live Bookings]
    H --> I[Review Payments & Wallet Transactions]
    H --> J[Manage User Accounts & Roles]
```

### Admin Responsibilities:
1. **Infrastructure Setup:** Create Locations &rarr; Add Theaters &rarr; Configure Screens &rarr; Generate Seats.
2. **Catalog Management:** Add Movies and Concession Categories/Products.
3. **Show Scheduling:** Assign Movie + Screen + Start Time into a Show.
4. **Monitoring & Auditing:** View all customer bookings, orders, and payment records.
