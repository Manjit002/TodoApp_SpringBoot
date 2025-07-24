package com.mjt.todoapplication.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    // Default value set to false
    private boolean status = false;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private LocalDateTime completedDate;

    @ManyToOne
    private UserEntity userEntity;


    public TodoEntity(Long id, String description, boolean status, LocalDateTime createdAt, LocalDateTime completedDate, UserEntity userEntity) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.completedDate = completedDate;
        this.userEntity = userEntity;
    }

    public TodoEntity() {
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