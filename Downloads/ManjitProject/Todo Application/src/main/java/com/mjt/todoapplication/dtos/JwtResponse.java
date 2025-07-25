package com.mjt.todoapplication.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class JwtResponse {
    private String token;

    UserDto user;
    private String refreshToken;



}
