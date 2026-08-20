package com.cinema.booking.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.tags.Tag;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class OpenApiConfig {

    private static final String SECURITY_SCHEME_NAME = "bearerAuth";
    private static final Map<String, String> TAG_ALIASES = Map.ofEntries(
            Map.entry("auth-controller", "Authentication"),
            Map.entry("location-controller", "Location"),
            Map.entry("theater-controller", "Theater"),
            Map.entry("screen-controller", "Screen"),
            Map.entry("seat-controller", "Seat"),
            Map.entry("movie-controller", "Movie"),
            Map.entry("show-controller", "Show"),
            Map.entry("category-controller", "Category"),
            Map.entry("product-controller", "Product"),
            Map.entry("booking-controller", "Booking"),
            Map.entry("booking-seat-controller", "BookingSeat"),
            Map.entry("order-controller", "Order"),
            Map.entry("order-item-controller", "OrderItem"),
            Map.entry("payment-controller", "Payment"),
            Map.entry("wallet-controller", "Wallet"),
            Map.entry("wallet-transaction-controller", "WalletTransaction"),
            Map.entry("user-controller", "User")
    );

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Cinema Management API")
                        .version("1.0.0")
                        .description("REST API for managing the Cinema Booking System"))
                .tags(List.of(
                        new Tag().name("Authentication").description("Endpoints for User Registration and Authentication"),
                        new Tag().name("Location").description("Endpoints for managing Location"),
                        new Tag().name("Theater").description("Endpoints for managing Theater"),
                        new Tag().name("Screen").description("Endpoints for managing Screen"),
                        new Tag().name("Seat").description("Endpoints for managing Seat"),
                        new Tag().name("Movie").description("Endpoints for managing Movie"),
                        new Tag().name("Show").description("Endpoints for managing Show"),
                        new Tag().name("Category").description("Endpoints for managing Category"),
                        new Tag().name("Product").description("Endpoints for managing Product"),
                        new Tag().name("Booking").description("Endpoints for managing Booking"),
                        new Tag().name("BookingSeat").description("Endpoints for managing BookingSeat"),
                        new Tag().name("Order").description("Endpoints for managing Order"),
                        new Tag().name("OrderItem").description("Endpoints for managing OrderItem"),
                        new Tag().name("Payment").description("Endpoints for managing Payment"),
                        new Tag().name("Wallet").description("Endpoints for managing Wallet"),
                        new Tag().name("WalletTransaction").description("Endpoints for managing WalletTransaction"),
                        new Tag().name("User").description("Endpoints for managing User")
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

    @Bean
    public OpenApiCustomizer normalizeControllerTags() {
        return openApi -> openApi.getPaths().values().forEach(pathItem ->
                pathItem.readOperations().forEach(operation -> {
                    if (operation.getTags() == null) {
                        return;
                    }
                    operation.setTags(operation.getTags().stream()
                            .map(tag -> TAG_ALIASES.getOrDefault(tag, tag))
                            .distinct()
                            .toList());
                }));
    }
}
