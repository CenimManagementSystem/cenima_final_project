                    React
                      │
                      │
                MovieController
                      │
                      ▼
                MovieService
                 /         \
                /           \
               ▼             ▼
       MovieRepository   CloudinaryService
              │                 │
              ▼                 ▼
          PostgreSQL        Cloudinary
              │                 │
              │             Movie poster
              │
              ├── title
              ├── genre
              ├── duration
              ├── poster_url
              └── poster_public_id