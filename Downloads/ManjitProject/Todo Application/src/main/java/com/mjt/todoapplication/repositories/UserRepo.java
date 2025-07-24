package com.mjt.todoapplication.repositories;


import com.mjt.todoapplication.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity,Long> {


    Optional<UserEntity> findByEmail(String email);

}
