package com.valore.backend.auth;

import com.valore.backend.user.Role;

public record AuthenticationResponse(
        String token,
        Role role,
        String firstname,
        String lastname
) {
}
