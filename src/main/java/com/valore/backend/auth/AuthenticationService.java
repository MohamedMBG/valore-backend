package com.valore.backend.auth;

import com.valore.backend.user.Role;
import com.valore.backend.user.User;
import com.valore.backend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        String email = normalizeEmail(request.email());

        if (userRepository.existsByEmail(email)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already in use");
        }

        // Without Spring, a Servlet would validate input, call JDBC/DAO code, hash the password,
        // and manage authentication state manually. Spring keeps that flow in one service with
        // JPA and Security beans, which reduces boilerplate and keeps layers clear.
        User user = User.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(email)
                .password(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .build();

        User savedUser = userRepository.save(user);
        String token = jwtService.generateToken(savedUser);
        return buildResponse(savedUser, token);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        String email = normalizeEmail(request.email());

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, request.password())
            );
        } catch (BadCredentialsException exception) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password");
        }

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password"));

        String token = jwtService.generateToken(user);
        return buildResponse(user, token);
    }

    private AuthenticationResponse buildResponse(User user, String token) {
        return new AuthenticationResponse(
                token,
                user.getRole(),
                user.getFirstname(),
                user.getLastname()
        );
    }

    private String normalizeEmail(String email) {
        return email.trim().toLowerCase();
    }
}
