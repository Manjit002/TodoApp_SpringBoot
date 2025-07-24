package com.mjt.todoapplication.services.Impl;

import com.mjt.todoapplication.dtos.TodoDto;
import com.mjt.todoapplication.entities.TodoEntity;
import com.mjt.todoapplication.exception.ResourceNotFoundException;
import com.mjt.todoapplication.repositories.TodoRepo;
import com.mjt.todoapplication.services.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class TodoServicesImpl implements TodoService {

    // Injecting the repository and the ModelMapper for database operations and object mapping
    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private ModelMapper mapper;

    // Method to create a new Todo
    @Override
    public TodoDto create(TodoDto todoDto) {
        TodoEntity mapped = mapper.map(todoDto, TodoEntity.class);
        TodoEntity saved = todoRepo.save(mapped);
        return mapper.map(saved, TodoDto.class);
    }

    // Method to update an existing Todo by ID
    @Override
    public TodoDto update(long id,TodoDto todoDto) {
        TodoEntity todo = todoRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));

        todo.setDescription(todoDto.getDescription());
        todo.setStatus(todoDto.isStatus());

//        Mere hisab se todo created date update nhi hona chahiye ap chahotho uncomment kar sakte ho.
//        todo.setCreatedAt(todoDto.getCreatedAt());

        todo.setCompletedDate(todoDto.getCompletedDate());
        TodoEntity saved = todoRepo.save(todo);

        return mapper.map(saved, TodoDto.class);
    }

    // Method to delete a Todo by ID
    @Override
    public String delete(long id) {
        TodoEntity todo = todoRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        todoRepo.delete(todo);
        return "Todo deleted";
    }

    // Method to get a single Todo by ID
    @Override
    public TodoDto get(long id) {
        TodoEntity todo = todoRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        return mapper.map(todo, TodoDto.class);
    }

    // Method to mark a Todo as completed
    @Override
    public TodoDto nowFinishMyTodo(long id) {
        TodoEntity todo = todoRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));

        todo.setStatus(true);
        todo.setCompletedDate(LocalDateTime.now());
        TodoEntity saved = todoRepo.save(todo);
        return mapper.map(saved, TodoDto.class);
    }

    // Method to retrieve all Todos with pagination
    @Override
    public PagedModel<TodoDto> getAll(Pageable pageable) {
        Page<TodoEntity> all = todoRepo.findAll(pageable);
        Page<TodoDto> mapped = all.map(todo -> mapper.map(todo, TodoDto.class));
        return new PagedModel<>(mapped);

    }

// Method to retrieve completed Todos with pagination
    @Override
    public PagedModel<TodoDto> getStatusCompleted(Pageable pageable) {
        Page<TodoEntity> allByTrue = todoRepo.findByStatusTrue(pageable);
        Page<TodoDto> mapped = allByTrue.map(todo -> mapper.map(todo, TodoDto.class));
        return new PagedModel<>(mapped);

        }

// Method to retrieve incomplete Todos with pagination
    @Override
    public PagedModel<TodoDto> getStatusIncomplete(Pageable pageable) {
        Page<TodoEntity> all = todoRepo.findByStatusFalse(pageable);
        Page<TodoDto> mapped = all.map(todo -> mapper.map(todo, TodoDto.class));
        return new PagedModel<>(mapped);

    }
}
