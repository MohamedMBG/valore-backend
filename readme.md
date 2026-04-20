# Valoré Backend — Digital Products Platform

## Overview

Valoré is a Spring Boot backend for a digital products platform
(PDF guides, templates, mini-courses), developed as part of a JEE academic project.

The platform allows users to:
- register and authenticate
- browse digital products
- interact with products (favorites, comments, ratings)
- manage a cart and validate orders

---

## Objective

The goal of this project is to:

- build a complete J2EE application using Spring Boot
- apply a layered architecture (Controller → Service → Repository)
- implement key backend features (authentication, CRUD, filtering, interactions)
- demonstrate the difference between:
    - traditional Java EE (Servlet, JSP, JDBC)
    - Spring-based development

Each major feature includes comments explaining these differences.

---

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Web (Spring MVC)
- Spring Data JPA
- Spring Security
- PostgreSQL (or H2)

---

## Architecture

The application follows a layered architecture:

- **Controller** → handles HTTP requests
- **Service** → contains business logic
- **Repository** → data access using Spring Data JPA
- **Entity** → database models
- **DTO** → data transfer objects
- **Config** → security and application configuration
- **Exception** → centralized error handling

---

## Features

### 1. Authentication & Users
- user registration
- secure login
- password encoding
- role-based access control (USER, ADMIN)
- protected routes using Spring Security

---

### 2. Product Management (CRUD)
- create, update, delete digital products
- view product list
- view product details

---

### 3. Search & Filtering
- search products by keyword
- filter by category or attributes

---

### 4. User Interaction
- add/remove favorites
- comment on products
- rate products

---

### 5. Cart & Orders
- add products to cart
- remove products from cart
- validate order

---

## Pedagogical Requirement

This project includes detailed comments explaining:

- how features would be implemented **without Spring**
    - Servlets
    - JSP
    - JDBC / JPA manual implementation
    - manual security filters and session handling

- differences between traditional Java EE and Spring

- advantages of Spring:
    - reduced boilerplate
    - simplified configuration
    - built-in security
    - better maintainability

These explanations are included directly in the code where relevant.

---

## Setup

### 1. Database

Create a PostgreSQL database:

```sql
CREATE DATABASE valore_db;