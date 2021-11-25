package com.vishvendra.MyTodo.Repository;

import com.vishvendra.MyTodo.Model.Todo;

import org.springframework.data.repository.CrudRepository;


public interface TodoRepository extends CrudRepository<Todo, Long > {

}


