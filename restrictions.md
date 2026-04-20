# RESTRICTIONS.md

This file defines the mandatory rules for any AI agent, coding assistant, or contributor working on this repository.

---

## 1. Mission

You are working on the **backend only**.

Your role is to build a clean, educational, and well-structured Spring Boot backend aligned with the JEE academic project.

You must NOT turn this project into:
- a complex SaaS platform
- an enterprise-grade architecture
- an overengineered system

---

## 2. Source of Truth

The source of truth for this project is:

1. The academic project requirements
2. `README.md`
3. This file `RESTRICTIONS.md`
4. The existing codebase

In case of conflict:
- Follow the academic subject first
- Then follow `RESTRICTIONS.md`
- Then maintain consistency with existing code

---

## 3. Allowed Scope

You are allowed to:

- Create and modify Spring Boot backend classes
- Add entities, DTOs, repositories, services, controllers
- Configure Spring Security
- Configure JPA
- Configure the database
- Add validation, error handling, mapping, and CORS
- Add pedagogical comments required by the project
- Improve code structure (only if it remains simple and consistent)

---

## 4. Forbidden Scope

You must NOT:

- Modify the frontend
- Introduce microservices architecture
- Add Kafka, Redis, RabbitMQ, Elasticsearch, or complex Docker setups
- Add advanced CI/CD pipelines
- Add Kubernetes
- Implement OAuth, SSO, or distributed architectures
- Add unnecessary design patterns just to “look professional”
- Add features outside the project scope
- Rename the entire project without strong justification
- Replace large parts of the existing code without reason

---

## 5. Required Tech Stack

You must use:

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Spring Security
- Maven
- Relational database (H2 or PostgreSQL)

Do NOT migrate to another stack.

---

## 6. Required Architecture

You must follow a simple layered architecture:

- controller
- service
- repository
- entity
- dto
- config
- exception
- mapper (if needed)

### Strict rules:

- No business logic in controllers
- No direct database access from controllers
- No skipping service layer
- No unnecessary “utility” classes

---

## 7. Coding Style Rules

Always prioritize:

- clarity
- simplicity
- readability
- consistency
- small and understandable classes

Avoid:

- overengineering
- premature abstraction
- unnecessary design patterns
- overly clever but unreadable code

---

## 8. Spring Security Rules

Spring Security is mandatory.

Security must include:

- authentication
- role-based authorization
- route protection
- password encoding

Do NOT disable or bypass security “temporarily” unless explicitly instructed.

---

## 9. Pedagogical Requirements

This project must include comments explaining:

- how features would be implemented WITHOUT Spring:
    - Servlets
    - JSP
    - JDBC / manual JPA
    - manual filters and sessions

- differences between traditional Java EE and Spring

- advantages of Spring:
    - reduced boilerplate
    - built-in security
    - easier maintenance

These comments must be:
- relevant
- concise
- placed in appropriate parts of the code

---

## 10. Database Rules

- Use JPA properly
- Define relationships clearly
- Avoid unnecessary queries
- Use consistent naming
- Do not create unnecessary tables

If a relationship exists → model it properly with JPA.

---

## 11. Feature Requirements

The backend must include:

1. Users and roles
2. Authentication
3. Main CRUD module
4. Search and filtering
5. User interactions
6. Cart and order (or equivalent domain logic)

Do NOT skip any required part.

---

## 12. Before Any Change

Always check:

- What is the exact requirement?
- Is the change within scope?
- Is this the simplest solution?
- Does it respect security?
- Does it follow layered architecture?

---

## 13. AI Agent Workflow

When working on a task:

1. Analyze existing code
2. Modify only what is necessary
3. Keep naming consistent
4. Produce compilable code
5. Avoid vague TODOs
6. Avoid fake implementations
7. Do not create unused classes
8. Do not break existing code

---

## 14. When Uncertain

If something is unclear:

- Do NOT invent complex logic
- Do NOT assume advanced architecture
- Use the simplest valid solution
- Keep code extendable but simple
- Add a short clarification comment if needed

---

## 15. Absolute Prohibitions

You must NEVER:

- Rewrite the entire project
- Introduce microservices
- Add Kafka / Redis / orchestration tools
- Overcomplicate architecture
- Mix business logic and security improperly
- Create inconsistent APIs
- Duplicate code excessively
- Produce non-compilable code
- Add dependencies without clear need

---

## 16. Final Objective

The goal is NOT to impress with complexity.

The goal is to deliver a backend that is:

- clean
- functional
- secure
- easy to understand
- aligned with academic requirements
- easy to present

---

## 17. Final Directive

If you are an AI agent:

- Read all configuration files first
- Strictly respect the scope
- Choose the simplest working solution
- Do NOT anticipate future features
- Keep the project clean, stable, and academic-focused