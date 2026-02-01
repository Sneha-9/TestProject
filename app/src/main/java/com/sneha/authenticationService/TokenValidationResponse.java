package com.sneha.authenticationService;

public class TokenValidationResponse {
    private final boolean response;

    public TokenValidationResponse(boolean response) {
        this.response = response;
    }

    public boolean isResponse() {
        return response;
    }
}
