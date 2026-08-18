package com.cinema.booking.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    private static final String SECURITY_SCHEME_NAME = "bearerAuth";

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Cinema Management API")
                        .version("1.0.0")
                        .description("REST API for managing the Cinema Booking System"))
                .tags(List.of(
                        new Tag().name("Authentication").description("Endpoints for User Registration and Authentication"),
                        new Tag().name("User").description("Endpoints for managing User"),
                        new Tag().name("Movie").description("Endpoints for managing Movie"),
                        new Tag().name("Category").description("Endpoints for managing Category"),
                        new Tag().name("Location").description("Endpoints for managing Location"),
                        new Tag().name("Theater").description("Endpoints for managing Theater"),
                        new Tag().name("Screen").description("Endpoints for managing Screen"),
                        new Tag().name("Seat").description("Endpoints for managing Seat"),
                        new Tag().name("Show").description("Endpoints for managing Show"),
                        new Tag().name("Product").description("Endpoints for managing Product"),
                        new Tag().name("Booking").description("Endpoints for managing Booking"),
                        new Tag().name("BookingSeat").description("Endpoints for managing BookingSeat"),
                        new Tag().name("Order").description("Endpoints for managing Order"),
                        new Tag().name("OrderItem").description("Endpoints for managing OrderItem"),
                        new Tag().name("Payment").description("Endpoints for managing Payment"),
                        new Tag().name("Wallet").description("Endpoints for managing Wallet"),
                        new Tag().name("WalletTransaction").description("Endpoints for managing WalletTransaction")
                ))
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .components(new Components()
                        .addSecuritySchemes(SECURITY_SCHEME_NAME, new SecurityScheme()
                                .name(SECURITY_SCHEME_NAME)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .description("JWT Authorization header using the Bearer scheme.")));
    }
}
