package com.example.niceapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Nigerian Healthcare & Hospital Management API",
        version = "1.0",
        description = "A RESTful Spring Boot API that tracks companies, assets, transactions and trade across multiple sectors.",
        contact = @Contact(
            name = "Darren Bassey", 
            email = "bassey.darrenasuquo@gmail.com"
        )
    )
)
public class SwaggerConfig {

}
