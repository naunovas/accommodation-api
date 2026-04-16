# Accommodation API

Backend application for managing accommodations, built using Java Spring Boot.

## Overview
This project was developed as part of laboratory exercises (Lab 2) for the Electronic and Mobile Commerce course.

It represents a backend system with layered architecture, including domain, application, and web layers, and supports managing accommodations, hosts, countries, and reviews.

## Technologies
- Java
- Spring Boot
- Spring Data JPA
- SQL Database
- Flyway (database migrations)

## Features
- CRUD operations for accommodations, hosts, countries, and reviews
- REST API endpoints
- Layered architecture (repository, service, controller)
- Database versioning with Flyway

## Project Structure
- `model` – domain entities and DTOs  
- `repository` – data access layer  
- `service` – business logic (domain & application)  
- `web` – REST controllers and exception handling  

## Running the Application
```bash
./mvnw spring-boot:run
