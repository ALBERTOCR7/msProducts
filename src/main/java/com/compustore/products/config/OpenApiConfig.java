package com.compustore.products.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de Swagger/OpenAPI para el microservicio de productos.
 * Permite probar endpoints protegidos por JWT directamente desde Swagger UI.
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI productsOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("CompuStore Products API")
                        .version("v1")
                        .description("Microservicio para la gestión de productos de CompuStore. " +
                                "Requiere autenticación JWT para la mayoría de sus endpoints. " +
                                "Utiliza roles 'ADMIN' y 'CLIENT'."))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .description("Ingrese el token JWT obtenido en el login del servicio de usuarios, sin la palabra 'Bearer'.")));
    }
}
