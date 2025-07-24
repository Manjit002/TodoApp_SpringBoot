package com.mjt.todoapplication.dtos;

import com.mjt.todoapplication.entities.TodoEntity;



import java.util.ArrayList;
import java.util.List;


public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;

    private List<TodoEntity> todos=new ArrayList<>();


    public UserDto(Long id, String name, String email, String password, List<TodoEntity> todos) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.todos = todos;
    }

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TodoEntity> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoEntity> todos) {
        this.todos = todos;
    }
}
