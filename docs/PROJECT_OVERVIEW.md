# Project Overview — Spring Boot Backend

## 1. Goal

Build a Spring Boot backend for a JEE academic project.

The backend must:
- support the existing frontend
- expose REST APIs
- implement authentication, CRUD, interactions, and orders
- include pedagogical comparison (Spring vs traditional JEE)

---

## 2. Frontend Context

- Framework: Next.js (App Router)
- Auth: NextAuth + JWT
- Base URL: http://localhost:8080/api
- Token: Authorization Bearer

Critical flow:

Auth → Products → Checkout → Order completion

Source: frontend analysis report. :contentReference[oaicite:0]{index=0}

---

## 3. Core Features

### Required for frontend

- Authentication (register, login)
- Products (list, detail)
- Orders (checkout, history)
- Quotes (list, create)
- User profile update
- Admin stats

---

### Required for academic project

- CRUD module
- Search & filtering
- Favorites
- Ratings
- Comments
- Cart

---

## 4. Tech Stack

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Spring Security
- Maven
- H2 or PostgreSQL
- JWT

---

## 5. Constraints

- Simple layered architecture
- No microservices
- No Kafka / Redis / Kubernetes
- No overengineering

---

## 6. Final Objective

Build a backend that is:

- simple
- secure
- functional
- easy to present
- aligned with frontend + academic requirements