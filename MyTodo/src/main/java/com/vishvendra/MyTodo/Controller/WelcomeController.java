package com.vishvendra.MyTodo.Controller;

import com.vishvendra.MyTodo.Model.Todo;
import com.vishvendra.MyTodo.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class WelcomeController {

    @Autowired
    private TodoService todoservice;

    @RequestMapping("/")
    public String slash() {
        return "index";
    }

    @RequestMapping(value = "/add-todo")
    public String view() {
        return "add-todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String save(@RequestParam String description, @RequestParam String dd, @RequestParam String mm, @RequestParam String yyyy) {
        Todo todo = new Todo();
        String tilldate = dd + "/" + mm + "/" + yyyy;
        todo.setDescription(description);
        todo.setTillDate(tilldate);
        boolean i = todoservice.createToDo(todo);
        if (i) {
            return "add-todo";
        }
        return "index";
    }

    @RequestMapping(value = "/show-todo", method = RequestMethod.GET)
    public ModelAndView show() {
        ModelAndView mv = new ModelAndView("show-todo");
        List<Todo> todo = todoservice.readToDo();
        mv.addObject("useMe", todo);
        return mv;
    }

    @RequestMapping(value = "/delete-todo")
    public ModelAndView remove(@RequestParam String id) {
        long convertedId = Long.parseLong(id);
        todoservice.deleteToDo(convertedId);
        ModelAndView mv = new ModelAndView("show-todo");
        List<Todo> todo = todoservice.readToDo();
        mv.addObject("useMe", todo);
        return mv;
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam long id, @RequestParam String description, @RequestParam String dd, @RequestParam String mm, @RequestParam String yyyy) {
        ModelAndView mv = new ModelAndView("add-todo");
        Todo op = todoservice.findById(id).get();
        op.setDescription(description);
        String tilldate = dd + "/" + mm + "/" + yyyy;
        op.setTillDate(tilldate);
        todoservice.createToDo(op);
        List<Todo> updatedList = todoservice.readToDo();
        mv.addObject("useMe", updatedList);
        return mv;
    }
}
