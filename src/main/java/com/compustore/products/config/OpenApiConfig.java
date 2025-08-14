package com.compustore.products.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import io.swagger.v3.oas.models.security.*;
import org.springframework.context.annotation.*;

@Configuration
public class OpenApiConfig {
  @Bean
  public OpenAPI productsOpenAPI() {
    return new OpenAPI()
      .info(new Info().title("CompuStore Products API").version("v1")
        .description("Gestión de productos protegida por JWT"))
      .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
      .components(new Components().addSecuritySchemes("bearerAuth",
        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
  }
}
