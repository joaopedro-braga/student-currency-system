# Student Currency System
System to stimulate the recognition of student merit through a virtual currency

## Description

This project implements a RESTful API for a Student Coin System, designed to incentivize student engagement and recognize academic achievements through a virtual currency. The system allows professors to award students with coins, which can later be redeemed for rewards and discounts from partner companies.

## Features

- **User Management:** Secure user registration and authentication for students, professors, and partner companies.
- **Coin Distribution:** Professors can award coins to students based on various criteria (participation, performance, etc.).
- **Reward Redemption:** Students can browse and redeem their earned coins for available rewards from partner companies.
- **Transaction History:** A transparent log of all coin transactions for auditing and tracking purposes.
- **Partner Company Management:** Companies can register, manage their offered rewards, and track redemptions.

## Technologies Used - Backend

**Language and Framework:**

- Java 17
- Spring Boot 3
- Spring Data JPA
- Spring Security (JWT)
- PostgreSQL

**Testing:**

- JUnit
- Mockito

**Tools:**

- Maven/Gradle
- Git
- Postman (for API testing)
- Swagger (for API documentation)

## Project Structure

The project follows a layered architecture:

- **API Layer (Controllers):** Handles HTTP requests, validates input, and delegates to the service layer.
- **Service Layer (Business Logic):** Implements business rules, manages transactions, and interacts with repositories.
- **Repository Layer (Data Access):** Provides abstraction over data persistence, using Spring Data JPA to interact with the database.

---
