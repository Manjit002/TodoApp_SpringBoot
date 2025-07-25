package com.mjt.todoapplication.dtos;





import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoDto {

    private Long id;


    private String description;

    // Default value set to false
    private boolean status = false;


    private LocalDateTime createdAt;

    private LocalDateTime completedDate;


    private UserDto user;

}