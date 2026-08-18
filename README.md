# Legacy System Integration Gateway

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.0-brightgreen)
![Build](https://img.shields.io/badge/Build-Maven-blue)
![Status](https://img.shields.io/badge/Status-Early%20Development-yellow)

A Java REST API that acts as an integration layer between a modern client and a simulated legacy system.

---
## Overview

The gateway provides a REST API for managing customers and communicates with a separate legacy service over HTTP.

The gateway does not access the legacy system's database directly. Instead, requests are passed to the legacy service, which is responsible for handling the underlying data.

### Target Architecture
```text
        Client
           |
           | HTTP / JSON
           v
REST Integration Gateway
           |
           | HTTP
           v
Simulated Legacy Service
           |
           | JDBC
           v
        PostgreSQL
```

---
## Current Progress

### Implemented
- [x] Spring Boot project setup
- [x] Maven project configuration
- [x] Simulated legacy service
- [x] Legacy customer REST endpoint

### In Progress
- [ ] HTTP communication between the gateway and legacy service
- [ ] Gateway customer endpoints

### Planned
- [ ] PostgreSQL persistence
- [ ] JDBC-based database access
- [ ] Request validation
- [ ] Error handling
- [ ] Unit and integration tests
- [ ] Docker support

---
## Project Structure
```
legacy-system-integration-gateway/
├── src/                    # Integration gateway
│
├── legacy-service/         # Simulated legacy system
│   ├── src/
│   ├── pom.xml
│   └── ...
│
├── pom.xml
└── README.md
```

---

## Tech Stack

### Current
- Java 21
- Spring Boot
- Maven
- REST / HTTP / JSON

### Planned
- PostgreSQL
- JDBC
- JUnit 5
- Mockito
- Docker
---

## Build & Run

### Gateway

From the project root:

```bash
./mvnw clean install
./mvnw spring-boot:run
```
On Windows, use `mvnw.cmd` instead of `./mvnw`.

```markdown
The gateway starts on:

http://localhost:8080
```

### Legacy Service

In separate terminal:

```bash
cd legacy-service
./mvnw clean install
./mvnw spring-boot:run
```
On Windows, use `mvnw.cmd` instead of `./mvnw`.

```markdown
The legacy service starts on:

http://localhost:8081
```