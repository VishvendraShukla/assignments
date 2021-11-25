package com.vishvendra.MyTodo.Service;

import com.vishvendra.MyTodo.Model.Todo;
import com.vishvendra.MyTodo.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    TodoRepository todoRepo;


    @Override
    public Optional<Todo> findById(long id) {
        return Optional.empty();
    }

    @Override
    public boolean createToDo(Todo todo) {
        todoRepo.save(todo);
        return true;
    }

    @Override
    public List<Todo> readToDo() {
        return (List<Todo>) todoRepo.findAll();
    }

    @Override
    public boolean updateToDo(long id) {
        return true;
    }

    @Override
    public boolean deleteToDo(long id) {
        todoRepo.deleteById(id);
        return true;
    }
}
