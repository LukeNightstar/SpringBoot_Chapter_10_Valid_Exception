package com.springboot.valid_exception.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {

    @Bean
    OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(getApiInfo());
    }

    private static Info getApiInfo() {
        return new Info().title("JPA TEST API DOCS").version("v1")
                .description("JPA API TEST 명세서");
    }

}
