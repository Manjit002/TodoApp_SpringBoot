package com.mjt.todoapplication.repositories;

import com.mjt.todoapplication.entities.TodoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TodoRepo extends JpaRepository<TodoEntity,Long> {

//    Get Status Incomplete
    Page<TodoEntity>findByStatusFalse(Pageable pageable);

//    Get Status Completed
    Page<TodoEntity>findByStatusTrue(Pageable pageable);
}
