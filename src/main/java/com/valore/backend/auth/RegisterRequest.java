package com.valore.backend.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(
        @NotBlank String firstname,
        @NotBlank String lastname,
        @Email @NotBlank String email,
        @NotBlank String password
) {
}
