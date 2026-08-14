SpringInit_Project.project_etec.cenima_project
│
├── config
│
├── controller
│   ├── AuthController.java
│   ├── MovieController.java
│   ├── TheaterController.java
│   ├── ScreenController.java
│   ├── SeatController.java
│   ├── ShowController.java
│   ├── BookingController.java
│   │
│   ├── ProductCategoryController.java
│   ├── ProductController.java
│   ├── OrderController.java
│   └── PaymentController.java
│
├── dto
│   ├── request
│   │   ├── MovieRequest.java
│   │   ├── BookingRequest.java
│   │   ├── ProductRequest.java
│   │   ├── OrderRequest.java
│   │   └── PaymentRequest.java
│   │
│   └── response
│       ├── MovieResponse.java
│       ├── BookingResponse.java
│       ├── ProductResponse.java
│       ├── OrderResponse.java
│       └── PaymentResponse.java
│
├── entity
│   ├── User.java
│   ├── Location.java
│   ├── Theater.java
│   ├── Movie.java
│   ├── Screen.java
│   ├── Seat.java
│   ├── Show.java
│   ├── Booking.java
│   ├── BookingSeat.java
│   │
│   ├── ProductCategory.java
│   ├── Product.java
│   ├── Order.java
│   ├── OrderItem.java
│   │
│   ├── Payment.java
│   ├── Wallet.java
│   └── WalletTransaction.java
│
├── enums
│   ├── UserRole.java
│   ├── MovieStatus.java
│   ├── BookingStatus.java
│   ├── PaymentStatus.java
│   │
│   ├── ProductStatus.java
│   ├── OrderStatus.java
│   ├── OrderType.java
│   └── PaymentMethod.java
│
├── exception
│
├── mapper
│   ├── MovieMapper.java
│   ├── BookingMapper.java
│   ├── ProductMapper.java
│   ├── OrderMapper.java
│   └── PaymentMapper.java
│
├── repository
│   ├── MovieRepository.java
│   ├── BookingRepository.java
│   ├── ProductCategoryRepository.java
│   ├── ProductRepository.java
│   ├── OrderRepository.java
│   ├── OrderItemRepository.java
│   └── PaymentRepository.java
│
└── service
├── MovieService.java
├── BookingService.java
├── ProductCategoryService.java
├── ProductService.java
├── OrderService.java
└── PaymentService.java