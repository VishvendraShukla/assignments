package com.vishvendra.MyToDo.Repository;

import com.vishvendra.MyToDo.Model.ToDo;

import org.springframework.data.repository.CrudRepository;


public interface TodoRepository extends CrudRepository< ToDo, Long > {

}


