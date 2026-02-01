package com.sneha.authenticationService;

public class TokenGenerationRequest {
    private final String userName;
    private final String password;


    TokenGenerationRequest(String userName, String password) {
        this.password = password;
        this.userName = userName;

    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }


}
