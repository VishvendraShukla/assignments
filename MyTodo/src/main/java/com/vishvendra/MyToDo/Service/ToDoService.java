package com.vishvendra.MyToDo.Service;

import com.vishvendra.MyToDo.Model.ToDo;
import com.vishvendra.MyToDo.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoService implements ToDoServiceInterface{
    @Autowired
    TodoRepository todoRepo;


    @Override
    public Optional<ToDo> findById(long id) {
        return  Optional.empty();
    }

    @Override
    public boolean createToDo(ToDo todo) {
        todoRepo.save(todo);
        return true;
    }

    @Override
    public List<ToDo> readToDo() {
        return (List<ToDo>) todoRepo.findAll();
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
