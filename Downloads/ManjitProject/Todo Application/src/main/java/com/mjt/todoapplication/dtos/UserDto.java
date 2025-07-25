package com.mjt.todoapplication.dtos;


import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;

    private List<TodoDto> todos = new ArrayList<>();


}
