# API Endpoints Specification

Complete REST API endpoint documentation for the Cinema Booking System.

> [!TIP]
> Interactive OpenAPI documentation and test console are available via Swagger UI at:
> `http://localhost:8081/swagger-ui/index.html` (or port configured in `application.properties`).

---

## 1. Authentication (`/api/auth`)

| Method | Endpoint | Description | Access |
|---|---|---|---|
| `POST` | `/api/auth/register` | Register a new user account | Public |
| `POST` | `/api/auth/login` | Login and receive a JWT Bearer token | Public |

---

## 2. Movies (`/api/movies`)

| Method | Endpoint | Description | Access |
|---|---|---|---|
| `GET` | `/api/movies` | Get list of all movies | Authenticated |
| `GET` | `/api/movies/{id}` | Get movie details by ID | Authenticated |
| `POST` | `/api/movies` | Create a new movie | Admin |
| `PUT` | `/api/movies/{id}` | Update movie details | Admin |
| `DELETE` | `/api/movies/{id}` | Delete a movie | Admin |

---

## 3. Theaters & Locations (`/api/theaters`, `/api/locations`)

| Method | Endpoint | Description | Access |
|---|---|---|---|
| `GET` | `/api/locations` | List all locations | Authenticated |
| `GET` | `/api/locations/{id}` | Get location by ID | Authenticated |
| `POST` | `/api/locations` | Create a location | Admin |
| `PUT` | `/api/locations/{id}` | Update a location | Admin |
| `DELETE` | `/api/locations/{id}` | Delete a location | Admin |
| `GET` | `/api/theaters` | List all theaters | Authenticated |
| `GET` | `/api/theaters/{id}` | Get theater by ID | Authenticated |
| `POST` | `/api/theaters` | Create a theater | Admin |
| `PUT` | `/api/theaters/{id}` | Update a theater | Admin |
| `DELETE` | `/api/theaters/{id}` | Delete a theater | Admin |

---

## 4. Screens & Seats (`/api/screens`, `/api/seats`)

| Method | Endpoint | Description | Access |
|---|---|---|---|
| `GET` | `/api/screens` | List all cinema screens | Authenticated |
| `GET` | `/api/screens/{id}` | Get screen by ID | Authenticated |
| `POST` | `/api/screens` | Create a new screen | Admin |
| `PUT` | `/api/screens/{id}` | Update a screen | Admin |
| `DELETE` | `/api/screens/{id}` | Delete a screen | Admin |
| `GET` | `/api/seats` | List all seats | Authenticated |
| `GET` | `/api/seats/{id}` | Get seat details by ID | Authenticated |
| `POST` | `/api/seats` | Create a seat | Admin |
| `PUT` | `/api/seats/{id}` | Update a seat | Admin |
| `DELETE` | `/api/seats/{id}` | Delete a seat | Admin |

---

## 5. Shows / Showtimes (`/api/shows`)

| Method | Endpoint | Description | Access |
|---|---|---|---|
| `GET` | `/api/shows` | List all showtimes | Authenticated |
| `GET` | `/api/shows/{id}` | Get showtime by ID | Authenticated |
| `POST` | `/api/shows` | Create a showtime | Admin |
| `PUT` | `/api/shows/{id}` | Update a showtime | Admin |
| `DELETE` | `/api/shows/{id}` | Delete a showtime | Admin |

---

## 6. Bookings & Seat Reservations (`/api/bookings`, `/api/booking-seats`)

| Method | Endpoint | Description | Access |
|---|---|---|---|
| `GET` | `/api/bookings` | List all bookings | Authenticated |
| `GET` | `/api/bookings/{id}` | Get booking by ID | Authenticated |
| `POST` | `/api/bookings` | Create a new booking | Authenticated |
| `PUT` | `/api/bookings/{id}` | Update a booking | Authenticated |
| `DELETE` | `/api/bookings/{id}` | Cancel/delete a booking | Authenticated |
| `GET` | `/api/booking-seats` | List reserved booking seats | Authenticated |
| `GET` | `/api/booking-seats/{id}` | Get booking seat by ID | Authenticated |
| `POST` | `/api/booking-seats` | Reserve seat for booking | Authenticated |
| `PUT` | `/api/booking-seats/{id}` | Update reserved seat | Authenticated |
| `DELETE` | `/api/booking-seats/{id}` | Release reserved seat | Authenticated |

---

## 7. Concessions & Products (`/api/categories`, `/api/products`)

| Method | Endpoint | Description | Access |
|---|---|---|---|
| `GET` | `/api/categories` | List food/beverage categories | Authenticated |
| `GET` | `/api/categories/{id}` | Get category by ID | Authenticated |
| `POST` | `/api/categories` | Create product category | Admin |
| `PUT` | `/api/categories/{id}` | Update product category | Admin |
| `DELETE` | `/api/categories/{id}` | Delete product category | Admin |
| `GET` | `/api/products` | List all products | Authenticated |
| `GET` | `/api/products/{id}` | Get product by ID | Authenticated |
| `POST` | `/api/products` | Create a product | Admin |
| `PUT` | `/api/products/{id}` | Update a product | Admin |
| `DELETE` | `/api/products/{id}` | Delete a product | Admin |

---

## 8. Orders & Order Items (`/api/orders`, `/api/order-items`)

| Method | Endpoint | Description | Access |
|---|---|---|---|
| `GET` | `/api/orders` | List customer orders | Authenticated |
| `GET` | `/api/orders/{id}` | Get order by ID | Authenticated |
| `POST` | `/api/orders` | Place a new order | Authenticated |
| `PUT` | `/api/orders/{id}` | Update an order | Authenticated |
| `DELETE` | `/api/orders/{id}` | Cancel/delete an order | Authenticated |
| `GET` | `/api/order-items` | List all order items | Authenticated |
| `GET` | `/api/order-items/{id}` | Get order item by ID | Authenticated |
| `POST` | `/api/order-items` | Add item to order | Authenticated |
| `PUT` | `/api/order-items/{id}` | Update order item | Authenticated |
| `DELETE` | `/api/order-items/{id}` | Remove order item | Authenticated |

---

## 9. Payments (`/api/payments`)

| Method | Endpoint | Description | Access |
|---|---|---|---|
| `GET` | `/api/payments` | List payments | Authenticated |
| `GET` | `/api/payments/{id}` | Get payment by ID | Authenticated |
| `POST` | `/api/payments` | Process a payment | Authenticated |
| `PUT` | `/api/payments/{id}` | Update payment record | Admin |
| `DELETE` | `/api/payments/{id}` | Delete payment record | Admin |

---

## 10. Wallets & Transactions (`/api/wallets`, `/api/wallet-transactions`)

| Method | Endpoint | Description | Access |
|---|---|---|---|
| `GET` | `/api/wallets` | List customer wallets | Authenticated |
| `GET` | `/api/wallets/{id}` | Get wallet by ID | Authenticated |
| `POST` | `/api/wallets` | Create a new wallet | Authenticated |
| `PUT` | `/api/wallets/{id}` | Update wallet | Authenticated |
| `DELETE` | `/api/wallets/{id}` | Delete wallet | Admin |
| `GET` | `/api/wallet-transactions` | List wallet transactions | Authenticated |
| `GET` | `/api/wallet-transactions/{id}` | Get wallet transaction by ID | Authenticated |
| `POST` | `/api/wallet-transactions` | Add wallet transaction | Authenticated |
| `PUT` | `/api/wallet-transactions/{id}` | Update transaction | Admin |
| `DELETE` | `/api/wallet-transactions/{id}` | Delete transaction | Admin |

---

## 11. User Management (`/api/users`)

| Method | Endpoint | Description | Access |
|---|---|---|---|
| `GET` | `/api/users` | List all users | Admin |
| `GET` | `/api/users/{id}` | Get user by ID | Authenticated |
| `POST` | `/api/users` | Create user | Admin |
| `PUT` | `/api/users/{id}` | Update user details | Authenticated |
| `DELETE` | `/api/users/{id}` | Delete user | Admin |
