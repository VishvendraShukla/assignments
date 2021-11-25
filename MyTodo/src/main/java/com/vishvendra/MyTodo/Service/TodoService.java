package com.vishvendra.MyTodo.Service;

import com.vishvendra.MyTodo.Model.Todo;

import java.util.List;
import java.util.Optional;


public interface TodoService {
    Optional<Todo> findById(long id);

    boolean createToDo(Todo todo);

    List<Todo> readToDo();

    boolean updateToDo(long id);

    boolean deleteToDo(long id);

}
