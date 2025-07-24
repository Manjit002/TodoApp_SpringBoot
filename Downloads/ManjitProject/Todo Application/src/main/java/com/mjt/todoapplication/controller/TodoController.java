package com.mjt.todoapplication.controller;

import com.mjt.todoapplication.dtos.TodoDto;
import com.mjt.todoapplication.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

//    http://localhost:9090/todo/create
    @PostMapping("/create")
    public ResponseEntity<TodoDto> create(@RequestBody TodoDto todoDto){
        TodoDto created = todoService.create(todoDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);

    }

//    http://localhost:9090/todo/update/6555415
    @PutMapping("/update/{id}")
    public ResponseEntity<TodoDto> update(@PathVariable long id,@RequestBody TodoDto todoDto){
        TodoDto updated = todoService.update(id,todoDto);
        return new ResponseEntity<>(updated, HttpStatus.ACCEPTED);
    }

//    http://localhost:9090/todo/delete/65446
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        String deleted = todoService.delete(id);
        return new ResponseEntity<>(deleted, HttpStatus.ACCEPTED);
    }

//    http://localhost:9090/todo/get/5465
    @GetMapping("/get/{id}")
    public ResponseEntity<TodoDto> getById(@PathVariable long id){
        TodoDto getTodo = todoService.get(id);
        return new ResponseEntity<>(getTodo, HttpStatus.OK);

    }

//    http://localhost:9090/todo/all
    @GetMapping("/all")
    public ResponseEntity<PagedModel<TodoDto>> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        PagedModel<TodoDto> allTodo = todoService.getAll(pageable);
        return new ResponseEntity<>(allTodo, HttpStatus.OK);
    }

//    http://localhost:9090/todo/all/complete
    @GetMapping("/all/complete")
    public ResponseEntity<PagedModel<TodoDto>> getByCompleted(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        PagedModel<TodoDto> completedTodo = todoService.getStatusCompleted(pageable);
        return new ResponseEntity<>(completedTodo, HttpStatus.OK);
    }

//    http://localhost:9090/todo/all/incomplete
    @GetMapping("/all/incomplete")
    public ResponseEntity<PagedModel<TodoDto>> getByIncomplete(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        PagedModel<TodoDto> incompleteTodo = todoService.getStatusIncomplete(pageable);
        return new ResponseEntity<>(incompleteTodo, HttpStatus.OK);
    }

//    http://localhost:9090/todo/now-finish/685466
    @GetMapping("/now-finish/{id}")
    public ResponseEntity<TodoDto> iAmFinishingMyTodo(@PathVariable long id){
        TodoDto finishMyTodo = todoService.nowFinishMyTodo(id);
        return new ResponseEntity<>(finishMyTodo,HttpStatus.ACCEPTED);
    }


}
