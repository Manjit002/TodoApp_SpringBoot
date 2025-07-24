package com.mjt.todoapplication.dtos;

import lombok.*;


@Setter
@Getter
@Builder
public class JwtResponse {
    private String token;

    UserDto user;
    private String refreshToken;

    public JwtResponse(String token, UserDto user, String refreshToken) {
        this.token = token;
        this.user = user;
        this.refreshToken = refreshToken;
    }

    public JwtResponse() {
    }

}
