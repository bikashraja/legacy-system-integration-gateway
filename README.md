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

### In Progress
- [ ] REST API
- [ ] Customer endpoints

### Planned
- [ ] Simulated legacy service
- [ ] HTTP communication between the gateway and legacy service
- [ ] PostgreSQL persistence
- [ ] JDBC-based database access
- [ ] Request validation
- [ ] Error handling
- [ ] Unit and integration tests
- [ ] Docker support

---
## Project Structure
```
The project is currently in the initial development stage. 
The structure will evolve as the gateway and simulated legacy service are added.
```

---

## Tech Stack

### Current
- Java 21
- Spring Boot
- Maven

### Planned
- REST / HTTP / JSON
- PostgreSQL
- JDBC
- JUnit 5
- Mockito
- Docker
---

## Build & Run

### Build
```bash
mvn clean install
```

### Run
```bash
mvn spring-boot:run
```

```markdown
The application will start on:

`http://localhost:8080`
```