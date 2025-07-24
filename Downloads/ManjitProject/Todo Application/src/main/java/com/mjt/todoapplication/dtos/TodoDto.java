package com.mjt.todoapplication.dtos;


import com.mjt.todoapplication.entities.UserEntity;


import java.time.LocalDateTime;


public class TodoDto {

    private Long id;


    private String description;

    // Default value set to false
    private boolean status = false;


    private LocalDateTime createdAt;

    private LocalDateTime completedDate;


    private UserEntity userEntity;

    public TodoDto(Long id, String description, boolean status, LocalDateTime createdAt, LocalDateTime completedDate, UserEntity userEntity) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.completedDate = completedDate;
        this.userEntity = userEntity;
    }

    public TodoDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(LocalDateTime completedDate) {
        this.completedDate = completedDate;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}