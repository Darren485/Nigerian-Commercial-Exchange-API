Below is a clean GitHub-ready README based on your current project specification. I’ve kept it aligned with the API design you provided and removed the unrelated E-commerce-project details from the previous README.

# Nigerian Commercial & Industrial Exchange Platform API

A RESTful API for managing companies, industrial and commercial assets, business transactions, and inquiries across multiple sectors in the Nigerian commercial and industrial ecosystem.

## Overview

The **Nigerian Commercial & Industrial Exchange Platform API** is a Spring Boot backend designed to provide a centralized platform for managing companies, assets, transactions, and business inquiries.

The platform supports multiple industry sectors, including:

* Oil & Gas
* Mining
* Maritime
* Finance
* Real Estate
* Trading
* Import & Export

The API uses **Spring Boot, Spring Data JPA, PostgreSQL, Spring Security, DTOs, validation, JPA auditing, global exception handling, and API versioning**.

---

## Features

* User registration and authentication
* Role-based authorization
* Company management
* Industrial and commercial asset management
* Transaction management
* Business inquiry/contact management
* Sector-based company searching
* Asset-type searching
* JPA entity relationships
* DTO-based API design
* Request validation
* Global exception handling
* JPA auditing
* CORS configuration
* Swagger/OpenAPI documentation
* PostgreSQL database
* Docker database support
* API versioning with `/api/v1`

---

## Technology Stack

| Technology         | Purpose                          |
| ------------------ | -------------------------------- |
| Java               | Programming language             |
| Spring Boot        | Application framework            |
| Spring Web         | REST API development             |
| Spring Data JPA    | Database access                  |
| Hibernate          | ORM                              |
| PostgreSQL         | Relational database              |
| Spring Security    | Authentication and authorization |
| BCrypt             | Password hashing                 |
| Lombok             | Boilerplate reduction            |
| Jakarta Validation | Request validation               |
| Swagger/OpenAPI    | API documentation                |
| Docker             | Database containerization        |
| Maven              | Build and dependency management  |

---

# API Base URL

```text
http://localhost:8080/api/v1
```

---

# API Endpoints

## Authentication

| Method | Endpoint         | Description     | Access |
| ------ | ---------------- | --------------- | ------ |
| POST   | `/auth/register` | Register a user | Public |
| POST   | `/auth/login`    | Login           | Public |

### Register

```http
POST /api/v1/auth/register
```

Example request:

```json
{
    "email": "admin@nicepa.com",
    "password": "admin123"
}
```

The role can be supplied according to the application's registration design.

### Login

```http
POST /api/v1/auth/login
```

Example request:

```json
{
    "email": "admin@nicepa.com",
    "password": "admin123"
}
```

Example authentication response:

```json
{
    "name": "Darren Bassey",
    "email": "admin@nicepa.com"
}
```

---

# Company API

| Method | Endpoint                           | Description                | Access |
| ------ | ---------------------------------- | -------------------------- | ------ |
| GET    | `/companies`                       | Get all companies          | Public |
| GET    | `/companies/{id}`                  | Get company by ID          | Public |
| POST   | `/companies`                       | Register a company         | ADMIN  |
| PUT    | `/companies/{id}`                  | Update a company           | ADMIN  |
| DELETE | `/companies/{id}`                  | Delete a company           | ADMIN  |
| GET    | `/companies/search?sector=OIL_GAS` | Search companies by sector | Public |

### Company Request

```json
{
    "companyName": "Seplat Energy PLC",
    "rcNumber": "RC-123456",
    "sector": "OIL_GAS",
    "subSector": "Upstream",
    "state": "Lagos",
    "country": "Nigeria",
    "stockTicker": "SEPLAT",
    "marketCapNGN": 850000000000.00,
    "status": "ACTIVE"
}
```

---

# Asset API

| Method | Endpoint                     | Description           | Access        |
| ------ | ---------------------------- | --------------------- | ------------- |
| GET    | `/assets`                    | Get all assets        | Public        |
| GET    | `/assets/{id}`               | Get asset by ID       | Public        |
| POST   | `/assets`                    | Add an asset          | ADMIN, TRADER |
| PUT    | `/assets/{id}`               | Update an asset       | ADMIN, TRADER |
| DELETE | `/assets/{id}`               | Delete an asset       | ADMIN, TRADER |
| GET    | `/assets/search?type=VESSEL` | Search assets by type | Public        |

### Asset Request

```json
{
    "assetName": "OML 53 Oil Block",
    "assetCode": "OML-053",
    "assetType": "OIL_WELL",
    "currentValueNGN": 500000000000.00,
    "currentValueUSD": 320000000.00,
    "quantity": 1,
    "unit": "block",
    "status": "ACTIVE",
    "companyId": 1
}
```

`companyId` identifies the company that owns the asset.

---

# Transaction API

| Method | Endpoint             | Description           | Access                 |
| ------ | -------------------- | --------------------- | ---------------------- |
| GET    | `/transactions`      | Get all transactions  | ADMIN, ANALYST, TRADER |
| GET    | `/transactions/{id}` | Get transaction by ID | ADMIN, ANALYST, TRADER |
| POST   | `/transactions`      | Create transaction    | ADMIN, TRADER          |
| PUT    | `/transactions/{id}` | Update transaction    | ADMIN, TRADER          |
| DELETE | `/transactions/{id}` | Delete transaction    | ADMIN                  |

### Transaction Request

```json
{
    "transactionCode": "TXN-2026-001",
    "transactionType": "BUY",
    "sector": "OIL_GAS",
    "buyerCompanyId": 1,
    "sellerCompanyId": 2,
    "assetId": 1,
    "amountNGN": 500000000000.00,
    "amountUSD": 320000000.00,
    "currency": "USD",
    "status": "PENDING",
    "tradeDate": "2026-09-01",
    "settlementDate": "2026-09-15"
}
```

The request uses IDs to identify related entities:

```text
buyerCompanyId → Company
sellerCompanyId → Company
assetId        → Asset
```

Response DTOs return related names rather than exposing relationship IDs directly.

---

# Contact API

| Method | Endpoint        | Description       | Access        |
| ------ | --------------- | ----------------- | ------------- |
| POST   | `/contact`      | Submit an inquiry | Authenticated |
| GET    | `/contact`      | Get all inquiries | Authenticated |
| GET    | `/contact/{id}` | Get inquiry by ID | Authenticated |
| DELETE | `/contact/{id}` | Delete inquiry    | Authenticated |

### Contact Request

```json
{
    "fullName": "Darren Bassey",
    "email": "darren@nicepa.com",
    "phoneNumber": "+2348012345678",
    "subject": "Partnership Inquiry",
    "message": "We are interested in listing our mining assets on your platform.",
    "sector": "MINING",
    "category": "PARTNERSHIP"
}
```

---

# Data Models

## User

`User` implements Spring Security's `UserDetails`.

```text
id
email
password
role
```

Available roles:

```text
ADMIN
ANALYST
TRADER
VIEWER
```

---

## Company

`Company` extends `Auditable`.

```text
id
companyName
rcNumber
sector
subSector
state
country
stockTicker
marketCapNGN
status
```

### Company Sectors

```text
OIL_GAS
MINING
MARITIME
FINANCE
REAL_ESTATE
TRADING
IMPORT_EXPORT
```

### Company Status

```text
ACTIVE
SUSPENDED
DELISTED
```

---

## Asset

`Asset` extends `Auditable`.

```text
id
assetName
assetCode
assetType
currentValueNGN
currentValueUSD
quantity
unit
status
company
```

### Asset Types

```text
STOCK
BOND
VESSEL
MINE
OIL_WELL
PROPERTY
COMMODITY
WAREHOUSE
```

### Asset Status

```text
ACTIVE
INACTIVE
UNDER_REVIEW
```

---

## Transaction

`Transaction` extends `Auditable`.

```text
id
transactionCode
transactionType
sector
buyerCompany
sellerCompany
asset
amountNGN
amountUSD
currency
status
tradeDate
settlementDate
```

### Transaction Types

```text
BUY
SELL
LEASE
CHARTER
EXPORT
IMPORT
MORTGAGE
SWAP
```

### Transaction Status

```text
PENDING
ACTIVE
SETTLED
CANCELLED
DISPUTED
```

### Supported Currencies

```text
NGN
USD
GBP
EUR
```

---

## ContactRequest

`ContactRequest` extends `Auditable`.

```text
id
fullName
email
phoneNumber
subject
message
sector
category
status
```

### Contact Categories

```text
COMPLAINT
PARTNERSHIP
INQUIRY
SUPPORT
```

### Contact Status

```text
OPEN
IN_PROGRESS
RESOLVED
CLOSED
```

---

# JPA Relationships

The application uses JPA relationships to represent ownership and transactions.

```text
Company
   │
   ├── OneToMany → Asset
   │
   ├── OneToMany → Transaction (as buyer)
   │
   └── OneToMany → Transaction (as seller)


Asset
   │
   └── OneToMany → Transaction
```

From the other side:

```text
Asset
   └── ManyToOne → Company

Transaction
   ├── ManyToOne → Company (buyerCompany)
   ├── ManyToOne → Company (sellerCompany)
   └── ManyToOne → Asset
```

Collections use:

```java
FetchType.LAZY
```

Child entities use the required delete behavior through JPA/Hibernate configuration.

---

# Security

The API uses **Spring Security** for authentication and role-based authorization.

## Authentication Components

* `User implements UserDetails`
* `CustomUserDetailsService`
* `DaoAuthenticationProvider`
* `SecurityConfig`
* `BCryptPasswordEncoder`
* `CustomAccessDeniedHandler`
* `CustomAuthenticationEntryPoint`
* CORS configuration

Passwords are hashed using BCrypt before being stored.

```text
Plain Password
      ↓
BCryptPasswordEncoder
      ↓
Hashed Password
      ↓
Database
```

During login, the submitted password is checked against the stored hash using the password encoder.

---

# Authorization Rules

| Endpoint                               | Access                 |
| -------------------------------------- | ---------------------- |
| `/api/v1/auth/**`                      | Public                 |
| `GET /api/v1/companies/**`             | Public                 |
| `GET /api/v1/assets/**`                | Public                 |
| `POST/PUT/DELETE /api/v1/companies/**` | ADMIN                  |
| `POST/PUT/DELETE /api/v1/assets/**`    | ADMIN, TRADER          |
| `POST /api/v1/transactions/**`         | ADMIN, TRADER          |
| `GET /api/v1/transactions/**`          | ADMIN, ANALYST, TRADER |
| `DELETE /api/v1/transactions/**`       | ADMIN                  |
| `/api/v1/contact/**`                   | Authenticated          |
| `/swagger-ui/**`                       | Public                 |

---

# Validation

Request DTOs use Jakarta Bean Validation to validate incoming data.

Example:

```java
@NotBlank(message = "Email is required")
@Email(message = "Please provide a valid email")
private String email;
```

Validation is triggered in controllers using:

```java
@Valid
```

Example:

```java
@PostMapping
public ResponseEntity<?> create(
        @Valid @RequestBody CompanyRequestDTO request) {
    
    // ...
}
```

---

# DTO Architecture

The application separates API models from JPA entities using DTOs.

## Request DTOs

```text
dto/request/

├── LoginRequestDTO.java
├── CompanyRequestDTO.java
├── AssetRequestDTO.java
├── TransactionRequestDTO.java
└── ContactRequestDTO.java
```

Request DTOs contain the information required from the client.

For relationships, request DTOs use IDs rather than complete entity objects.

Example:

```java
private Long companyId;
```

rather than:

```java
private Company company;
```

## Response DTOs

```text
dto/response/

├── AuthResponseDTO.java
├── CompanyResponseDTO.java
├── AssetResponseDTO.java
├── TransactionResponseDTO.java
└── ContactResponseDTO.java
```

Response DTOs expose the information intended for API consumers while avoiding direct exposure of JPA entities.

Related entities are represented by their names where appropriate.

---

# Exception Handling

The application uses centralized exception handling.

```text
exception/

├── CompanyNotFoundException.java
├── AssetNotFoundException.java
├── TransactionNotFoundException.java
├── ContactNotFoundException.java
├── ErrorResponse.java
└── GlobalExceptionHandler.java
```

`GlobalExceptionHandler` provides consistent API error responses for application exceptions and validation failures.

---

# JPA Auditing

Entities that extend `Auditable` automatically track auditing information.

The auditing configuration is located in:

```text
config/AuditConfig.java
```

This allows the application to maintain information about changes made to persistent entities.

---

# Project Structure

```text
com.example.nicepapi/
│
├── controller/
│   ├── AuthController.java
│   ├── CompanyController.java
│   ├── AssetController.java
│   ├── TransactionController.java
│   └── ContactController.java
│
├── service/
│   ├── AuthService.java
│   ├── CompanyService.java
│   ├── AssetService.java
│   ├── TransactionService.java
│   └── ContactService.java
│
├── repository/
│   ├── UserRepository.java
│   ├── CompanyRepository.java
│   ├── AssetRepository.java
│   ├── TransactionRepository.java
│   └── ContactRepository.java
│
├── model/
│   ├── Auditable.java
│   ├── User.java
│   ├── Company.java
│   ├── Asset.java
│   ├── Transaction.java
│   └── ContactRequest.java
│
├── dto/
│   ├── request/
│   │   ├── LoginRequestDTO.java
│   │   ├── CompanyRequestDTO.java
│   │   ├── AssetRequestDTO.java
│   │   ├── TransactionRequestDTO.java
│   │   └── ContactRequestDTO.java
│   │
│   └── response/
│       ├── AuthResponseDTO.java
│       ├── CompanyResponseDTO.java
│       ├── AssetResponseDTO.java
│       ├── TransactionResponseDTO.java
│       └── ContactResponseDTO.java
│
├── exception/
│   ├── CompanyNotFoundException.java
│   ├── AssetNotFoundException.java
│   ├── TransactionNotFoundException.java
│   ├── ContactNotFoundException.java
│   ├── ErrorResponse.java
│   └── GlobalExceptionHandler.java
│
├── security/
│   ├── CustomUserDetailsService.java
│   ├── CustomAccessDeniedHandler.java
│   └── CustomAuthenticationEntryPoint.java
│
├── config/
│   ├── SecurityConfig.java
│   ├── AuditConfig.java
│   └── SwaggerConfig.java
│
└── NicepapiApplication.java
```

---

# Getting Started

## Prerequisites

Install the following:

* Java
* Maven
* Docker
* Git
* PostgreSQL (optional if using Docker)

---

## Clone the Repository

```bash
git clone <YOUR_REPOSITORY_URL>
cd nicepapi
```

Replace `<YOUR_REPOSITORY_URL>` with the actual GitHub repository URL.

---

# Database Setup

The application uses PostgreSQL.

Start PostgreSQL with Docker:

```bash
docker run --name nicepapidb \
-e POSTGRES_PASSWORD=password \
-e POSTGRES_DB=nicepapidb \
-p 5432:5432 \
-d postgres:15
```

Verify that the container is running:

```bash
docker ps
```

---

# Application Configuration

Create or update:

```text
src/main/resources/application.properties
```

with:

```properties
spring.application.name=niceapi

spring.datasource.url=jdbc:postgresql://localhost:5432/nicepapidb
spring.datasource.username=postgres
spring.datasource.password=password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

server.port=8080
```

---

# Running the Application

Build the project:

```bash
mvn clean package
```

Run the application:

```bash
mvn spring-boot:run
```

The API will be available at:

```text
http://localhost:8080
```

API endpoints use:

```text
http://localhost:8080/api/v1
```

---

# API Documentation

Swagger/OpenAPI documentation is provided through the application's Swagger configuration.

When enabled, Swagger UI is available at:

```text
http://localhost:8080/swagger-ui/index.html
```

---

# Testing with Postman

The API can be tested using Postman.

Recommended testing order:

```text
1. Register user
2. Login
3. Create company
4. Create asset
5. Create transaction
6. Submit contact request
7. Test protected endpoints
8. Test validation errors
9. Test exception handling
10. Test role-based authorization
```

---

# Development Order

The project is developed in the following order:

```text
1. Models
      ↓
2. DTOs
      ↓
3. Repositories
      ↓
4. Exceptions
      ↓
5. Configuration + Security
      ↓
6. Services
      ↓
7. Controllers
```

This structure separates responsibilities across the application layers.

---

# Architecture

The application follows a layered architecture:

```text
Client
  │
  ▼
Controller
  │
  ▼
Service
  │
  ▼
Repository
  │
  ▼
PostgreSQL
```

DTOs are used between the API and application layers:

```text
Client
  │
  ▼
Request DTO
  │
  ▼
Controller
  │
  ▼
Service
  │
  ▼
Entity
  │
  ▼
Repository
  │
  ▼
Database
```

Responses follow the reverse process:

```text
Database
   ↓
Entity
   ↓
Service
   ↓
Response DTO
   ↓
Controller
   ↓
Client
```

---

# API Design Principles

The API follows several backend development practices:

* RESTful endpoint design
* API versioning
* DTO separation
* Layered architecture
* Repository pattern
* Service-layer business logic
* Bean validation
* Centralized exception handling
* Role-based authorization
* Password hashing
* Lazy loading for collections
* JPA relationships
* JPA auditing
* CORS configuration
* OpenAPI documentation

---

# Future Improvements

Potential future additions include:

* Pagination
* Sorting and advanced filtering
* Transaction reporting
* Advanced search
* Dashboard analytics
* File/document management
* Notification system
* Rate limiting
* Production deployment configuration
* Automated integration testing

---

# License

This project is currently intended as a capstone/portfolio project.

---

## Project Status

**Status:** In Development

**API Version:** `v1`

**Application:** Nigerian Commercial & Industrial Exchange Platform API
