package com.mjt.todoapplication.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class JwtRequest {
    private String email;
    private String password;


}
