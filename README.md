# Delivery Spring Boot App

Simple Spring Boot app with Alpine.js frontend and Spring Data JDBC backend.

## Prerequisites

- Java 24
- Maven (or use `./mvnw` wrapper)
- PostgreSQL

## Quick Start

**Install PostgreSQL:**
```bash
brew install postgresql && brew services start postgresql
```

**Run the app:**
```bash
./mvnw spring-boot:run
```

**Open:** http://localhost:8080

**Stop:** `Ctrl+C`

## Development

**Run tests:**
```bash
./mvnw test
```

**Clean build:**
```bash
./mvnw clean
``` 