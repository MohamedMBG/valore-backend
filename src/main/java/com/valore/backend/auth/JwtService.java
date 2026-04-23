package com.valore.backend.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.valore.backend.user.User;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private final Algorithm algorithm;
    private final JWTVerifier verifier;
    private final long expiration;

    public JwtService(
            @Value("${application.security.jwt.secret-key}") String secretKey,
            @Value("${application.security.jwt.expiration}") long expiration
    ) {
        this.algorithm = Algorithm.HMAC256(secretKey);
        this.verifier = JWT.require(algorithm).build();
        this.expiration = expiration;
    }

    public String extractUsername(String token) {
        try {
            return verifier.verify(token).getSubject();
        } catch (JWTVerificationException exception) {
            return null;
        }
    }

    public String generateToken(User user) {
        Date issuedAt = new Date();
        Date expiresAt = new Date(issuedAt.getTime() + expiration);

        return JWT.create()
                .withSubject(user.getUsername())
                .withClaim("role", user.getRole().name())
                .withIssuedAt(issuedAt)
                .withExpiresAt(expiresAt)
                .sign(algorithm);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        try {
            DecodedJWT decodedJWT = verifier.verify(token);
            return decodedJWT.getSubject().equals(userDetails.getUsername())
                    && decodedJWT.getExpiresAt().after(new Date());
        } catch (JWTVerificationException exception) {
            return false;
        }
    }
}
