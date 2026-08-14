                    CINEMA SYSTEM
                         │
        ┌────────────────┼────────────────┐
        │                │                │
      MOVIE           THEATER          CUSTOMER
        │                │                │
        │              SCREEN             │
        │                │                │
        │              SEAT               │
        │                │                │
        └─────── SHOW ───┘                │
                 │                        │
                 ▼                        │
              BOOKING ◄──────────────────┘
                 │
          ┌──────┴──────┐
          │             │
        SEATS          ORDER
                        │
                  ┌─────┴─────┐
                  │           │
              PRODUCTS    ORDER_ITEMS
                  │
          ┌───────┼────────┐
          │       │        │
       POPCORN  DRINK     FOOD