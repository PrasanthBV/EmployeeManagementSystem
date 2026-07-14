package com.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI employeeOpenAPI() {

		return new OpenAPI().info(
				new Info().title("Employee Service API").version("1.0").description("REST APIs for Employee Management")
						.contact(new Contact().name("Raju").email("admin@company.com")));
	}
}