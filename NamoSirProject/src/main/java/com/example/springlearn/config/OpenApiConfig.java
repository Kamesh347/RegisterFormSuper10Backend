package com.example.springlearn.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Form Management API",
                version = "1.0.0",
                description = "This project provides RESTful APIs for managing frominfo data within an organization. It supports common operations such as retrieving from details, searching by criteria, and maintaining Form records.",
                contact = @Contact(
                        name = "Aditya Pore"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
                )
        )
)
public class OpenApiConfig {
}
