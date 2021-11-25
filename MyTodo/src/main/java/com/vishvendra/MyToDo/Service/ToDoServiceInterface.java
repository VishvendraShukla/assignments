package com.vishvendra.MyToDo.Service;

import com.vishvendra.MyToDo.Model.ToDo;

import java.util.List;
import java.util.Optional;


public interface ToDoServiceInterface {
    Optional<ToDo> findById(long id);
    boolean createToDo(ToDo todo);
    List<ToDo> readToDo();
    boolean updateToDo(long id);
    boolean deleteToDo(long id);

}
