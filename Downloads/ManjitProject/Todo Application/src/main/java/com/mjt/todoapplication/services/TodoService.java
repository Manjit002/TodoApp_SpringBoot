package com.mjt.todoapplication.services;

import com.mjt.todoapplication.dtos.TodoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;


public interface TodoService {

    TodoDto create (TodoDto todoDto);
    TodoDto update (long id,TodoDto todoDto);
    String delete (long id);
    TodoDto get (long id);
    TodoDto nowFinishMyTodo(long id);
    PagedModel<TodoDto> getAll(Pageable pageable);
    PagedModel<TodoDto>getStatusCompleted(Pageable pageable);
    PagedModel<TodoDto>getStatusIncomplete(Pageable pageable);



}
