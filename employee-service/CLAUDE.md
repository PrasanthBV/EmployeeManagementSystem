# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

- Build: `./mvnw clean package` (or `mvnw.cmd clean package` on Windows)
- Run tests: `./mvnw test`
- Run a single test: `./mvnw test -Dtest=EmployeeServiceApplicationTests`
- Run the application: `./mvnw spring-boot:run`
- (Optional) Devtools enables restart on classpath changes.

## Architecture

This is a minimal Spring Boot application serving as an employee service. It includes:
- Spring Boot Actuator for health and info endpoints.
- Spring Data JPA for database access (MySQL driver configured).
- Spring Validation for bean validation.
- Spring Web MVC for REST endpoints.
- Spring Cloud Netflix Eureka Client for service discovery.
- Spring Cloud OpenFeign for declarative REST clients.
- Lombok for reducing boilerplate.
- Devtools for automatic restart during development.

The main application class is `EmployeeServiceApplication`. No additional source code (controllers, services, repositories, entities) is present yet. A single placeholder test exists in `EmployeeServiceApplicationTests`.

## Notes

- Java version: 17 (configured in pom.xml).
- Spring Boot version: 4.1.0.
- Spring Cloud version: 2025.1.2.
- Maven Wrapper is used; no need to install Maven separately.