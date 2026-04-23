# Architecture — Spring Boot Backend

## 1. Architecture Style

Layered architecture:

Controller → Service → Repository → Database

---

## 2. Package Structure

com.project.backend

- auth
- user
- product
- quote
- order
- admin
- config
- exception

Optional (academic):
- favorite
- rating
- comment
- cart

---

## 3. Modules

### Auth
- register
- login
- JWT generation
- security filter

---

### User
- profile update
- role management

---

### Product
- CRUD
- search/filter
- admin management

---

### Quote
- list quotes
- create quote

---

### Order
- create checkout session (fake Stripe)
- complete order
- get user orders

---

### Admin
- dashboard stats

---

## 4. Main Entities

### User
- id
- firstname
- lastname
- email
- password
- role

---

### Product
- id
- title
- description
- price
- category
- imageUrl
- rating
- reviews

---

### Quote
- id
- text
- author
- category

---

### Order
- id
- user
- products
- stripeSessionId
- status
- createdAt

---

## 5. Security

### Public
- /auth/register
- /auth/authenticate
- /products
- /products/{id}
- /quotes

---

### USER
- quotes POST
- orders
- checkout
- profile update

---

### ADMIN
- product CRUD
- admin stats

---

## 6. API Base

All endpoints:

/api/...

---

## 7. Design Rules

- No logic in controllers
- No direct DB access outside repositories
- Use services for business logic
- Use DTOs for API responses