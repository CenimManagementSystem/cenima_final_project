                    ┌──────────────┐
                    │   main       │
                    │  production  │
                    └──────▲───────┘
                           │
                       PR + CI
                           │
                    ┌──────┴───────┐
                    │     dev      │
                    │ integration  │
                    └──────▲───────┘
                           │
                    PR + CI + Qodana
                           │
          ┌────────────────┼────────────────┐
          │                │                │
     feature/login   feature/payment   feature/movie
          │                │                │
       developer        developer        developer