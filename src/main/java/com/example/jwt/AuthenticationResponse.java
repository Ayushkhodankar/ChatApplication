package com.example.jwt;

import lombok.Data;

@Data
public class AuthenticationResponse {
	private final String token;

    public AuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
    
    
}