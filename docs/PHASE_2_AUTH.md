## 1. ANALYSIS
- Existing: Spring Boot skeleton only, with base dependencies in [pom.xml](</c:/Users/pc/IdeaProjects/valore-backend/pom.xml:32>) and no auth module, no entities, no repositories, no security config.
- Missing: `User` entity, `Role` enum, `UserRepository`, BCrypt password encoding, JWT creation/validation, JWT request filter, and protected-by-default Spring Security.
- Target: implement Phase 2 auth only with `POST /api/auth/register` and `POST /api/auth/authenticate`, using controller → service → repository, default role `USER`, public auth routes, and all other routes protected.

## 2. PLAN
- Add minimal user/auth classes: entity, enum, repository, DTOs, service, controller.
- Add JWT service, JWT authentication filter, and Spring Security beans/config.
- Add only required runtime config/dependencies, then verify with Maven tests.

## 3. IMPLEMENTATION
- User model and repository added in [User.java](</c:/Users/pc/IdeaProjects/valore-backend/src/main/java/com/valore/backend/user/User.java:27>), [Role.java](</c:/Users/pc/IdeaProjects/valore-backend/src/main/java/com/valore/backend/user/Role.java:1>), and [UserRepository.java](</c:/Users/pc/IdeaProjects/valore-backend/src/main/java/com/valore/backend/user/UserRepository.java:6>). `User` stores `firstname`, `lastname`, `email`, encoded `password`, and `role`, with unique email and `ROLE_*` authorities.
- Auth flow added in [AuthenticationController.java](</c:/Users/pc/IdeaProjects/valore-backend/src/main/java/com/valore/backend/auth/AuthenticationController.java:12>), [AuthenticationService.java](</c:/Users/pc/IdeaProjects/valore-backend/src/main/java/com/valore/backend/auth/AuthenticationService.java:15>), [RegisterRequest.java](</c:/Users/pc/IdeaProjects/valore-backend/src/main/java/com/valore/backend/auth/RegisterRequest.java:5>), [AuthenticationRequest.java](</c:/Users/pc/IdeaProjects/valore-backend/src/main/java/com/valore/backend/auth/AuthenticationRequest.java:5>), and [AuthenticationResponse.java](</c:/Users/pc/IdeaProjects/valore-backend/src/main/java/com/valore/backend/auth/AuthenticationResponse.java:5>). Registration assigns `USER` and hashes with BCrypt; authentication returns `token`, `role`, `firstname`, `lastname`.
- JWT support added in [JwtService.java](</c:/Users/pc/IdeaProjects/valore-backend/src/main/java/com/valore/backend/auth/JwtService.java:14>) and [JwtAuthenticationFilter.java](</c:/Users/pc/IdeaProjects/valore-backend/src/main/java/com/valore/backend/config/JwtAuthenticationFilter.java:19>). The filter reads `Authorization: Bearer ...`, validates the token, loads the user, and fills the Spring Security context.
- Security configuration added in [ApplicationConfig.java](</c:/Users/pc/IdeaProjects/valore-backend/src/main/java/com/valore/backend/config/ApplicationConfig.java:14>) and [SecurityConfig.java](</c:/Users/pc/IdeaProjects/valore-backend/src/main/java/com/valore/backend/config/SecurityConfig.java:15>). `/api/auth/register` and `/api/auth/authenticate` are public; every other route is authenticated; sessions, form login, and basic auth are disabled.
- Minimal config/deps added in [application.properties](</c:/Users/pc/IdeaProjects/valore-backend/src/main/resources/application.properties:1>) and [pom.xml](</c:/Users/pc/IdeaProjects/valore-backend/pom.xml:55>) for JWT library, H2 runtime, JPA startup, and JWT secret/expiration.
- Verification: `.\\mvnw.cmd test` passed.

## 4. NOTES
- No unrelated source files were changed.
- `register` currently returns the same auth response structure as login, which keeps the flow simple and usable.

## 5. DOC
What:
- Phase 2 authentication lets users register, log in, receive a JWT, and access protected routes securely.

How Spring:
- Controller receives the request, service applies auth logic, repository loads/saves the user.
- Spring Security uses `UserDetailsService` + BCrypt for credential verification.
- The JWT filter runs before protected requests, restores the authenticated user, and exposes the user role to authorization.

Without Spring:
- A Servlet would read the request, call JDBC/DAO code, hash passwords manually, and create session/auth state itself.
- A manual filter would parse the token/header on every request and store user data by hand.
- Spring removes that boilerplate and keeps auth logic inside clear layers.

## 6. AUDIT
Choices:
- Kept one small auth module with Spring Security defaults, BCrypt, and a single repository-backed user model.

Trade-offs:
- Used H2 runtime config for simple local/test startup; no PostgreSQL-specific setup was added in this phase.

Not done:
- No refresh tokens, no role-specific route rules beyond protected-by-default, no extra modules or unrelated CRUD work.
