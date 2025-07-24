package com.mjt.todoapplication.dtos;

import lombok.*;


@Setter
@Getter
@Builder
public class JwtRequest {
    private String email;
    private String password;

    public JwtRequest() {
    }

    public JwtRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
