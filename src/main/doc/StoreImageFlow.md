

                 ┌──────────────┐
                 │    React     │
                 └──────┬───────┘
                        │
                        ▼
                 ┌──────────────┐
                 │ Spring Boot  │
                 └──────┬───────┘
                        │
             ┌──────────┴──────────┐
             ▼                     ▼
       ┌───────────┐         ┌────────────┐
       │ Database  │         │ Cloudinary │
       └───────────┘         └────────────┘
             │                     │
       product data            actual image
       image_url               image file
       public_id



                                                    React
                                                       │
                                             │ DELETE /api/products/1
                                                       │
                                                       ▼
                                                Spring Boot
                                                       │
                                                       ▼
                                                   Database
                                                       │
                                                       ▼
                                                Cloudinary
                                                       │
                                                       ▼
                                                   Database
                                                       │
                                                       ▼
                                                   Database





                                                                    ┌──────────────┐
                                                                    │    React     │
                                                                    └──────┬───────┘
                                                                            │
                                                                            ▼
                                                                    ┌──────────────┐
                                                                    │ Spring Boot  │
                                                                    └──────┬───────┘
                                                                            │
                                                                ┌──────────┴──────────┐
                                                                ▼                     ▼
                                                        ┌───────────┐         ┌────────────┐
                                                        │ Database  │         │ Cloudinary │
                                                        └───────────┘         └────────────┘
                                                                │                     │
                                                        product data            actual image
                                                        image_url               image file
                                                        public_id