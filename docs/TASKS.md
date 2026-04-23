# Tasks — Spring Boot Backend

## ~~Phase 1 — Setup ( Already DONE )~~

- ~~Create Spring Boot project~~
- ~~Add dependencies:~~
  - ~~Web~~
  - ~~JPA~~
  - ~~Security~~
  - ~~DB~~
- ~~Configure application.properties~~
- ~~Setup packages~~

---

## Phase 2 — Authentication (CRITICAL)

Tasks:
- User entity
- Role enum
- UserRepository
- Password encoding
- JWT generation
- JWT filter
- Security config

Endpoints:
- POST /api/auth/register
- POST /api/auth/authenticate

---

## Phase 3 — Products (CRITICAL)

Tasks:
- Product entity
- Repository
- Service
- Controller
- CRUD operations

Endpoints:
- GET /api/products
- GET /api/products/{id}
- POST /api/products (ADMIN)
- PUT /api/products/{id} (ADMIN)
- DELETE /api/products/{id} (ADMIN)

---

## Phase 4 — Orders / Checkout (CRITICAL)

Tasks:
- Order entity
- Order repository
- Service
- Fake checkout logic
- Order completion

Endpoints:
- POST /api/stripe/create-checkout-session
- POST /api/stripe/complete-order
- GET /api/orders/my

---

## Phase 5 — Quotes (MEDIUM)

Tasks:
- Quote entity
- Repository
- Service
- Controller

Endpoints:
- GET /api/quotes
- POST /api/quotes

---

## Phase 6 — User Profile (MEDIUM)

Tasks:
- Update profile
- Return user data

Endpoint:
- PATCH /api/users/me

---

## Phase 7 — Admin (MEDIUM)

Tasks:
- Count users
- Count orders
- Count products
- Calculate revenue

Endpoint:
- GET /api/admin/stats

---

## Phase 8 — Academic Features

Tasks:
- Favorites
- Ratings
- Comments
- Cart

Example endpoints:

- POST /api/products/{id}/favorites
- POST /api/products/{id}/ratings
- POST /api/products/{id}/comments
- GET /api/products/{id}/comments

Cart:

- POST /api/cart/items
- GET /api/cart
- DELETE /api/cart/items/{id}
- POST /api/cart/checkout

---

## MVP Order

1. Auth
2. Products
3. Checkout
4. Orders

Then:

5. Quotes
6. Profile
7. Admin

Finally:

8. Favorites
9. Ratings
10. Comments
11. Cart

---

## Rules

- Keep it simple
- Follow architecture
- Do not overengineer
- Do not add unnecessary features