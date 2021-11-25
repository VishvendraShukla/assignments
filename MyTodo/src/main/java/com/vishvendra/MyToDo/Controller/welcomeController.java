package com.vishvendra.MyToDo.Controller;

import com.vishvendra.MyToDo.Model.ToDo;
import com.vishvendra.MyToDo.Service.ToDoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@Controller
public class welcomeController {

    @Autowired
    private ToDoServiceInterface ToDoService;

    @RequestMapping("/")
    public String slash(){
        return "index";
    }

    @RequestMapping(value = "/add-todo")
    public String view(){
        return "add-todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String save(@RequestParam String description,@RequestParam String dd,@RequestParam String mm,@RequestParam String yyyy){
        ToDo todo = new ToDo();
        String tilldate = dd+"/"+mm+"/"+yyyy;
        todo.setDescription(description);
        todo.setTillDate(tilldate);
        boolean i = ToDoService.createToDo(todo);
        if(i){
            return "add-todo";
        }
        return "index";
    }
    @RequestMapping(value = "/show-todo", method = RequestMethod.GET)
    public ModelAndView show(){
        ModelAndView mv = new ModelAndView("show-todo");
        List<ToDo> todo = (List<ToDo>) ToDoService.readToDo();
        mv.addObject("useMe",todo);
        return mv;
    }
    @RequestMapping(value = "/delete-todo")
    public ModelAndView remove(@RequestParam String id){
        long converted_id = Long.parseLong(id);
        ToDoService.deleteToDo(converted_id);
        ModelAndView mv = new ModelAndView("show-todo");
        List<ToDo> todo = (List<ToDo>) ToDoService.readToDo();
        mv.addObject("useMe",todo);
        return mv;
    }
    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public ModelAndView update(@RequestParam long id){
        ModelAndView mv = new ModelAndView("add-todo");
        ToDo op = ToDoService.findById(id).get();


        return mv;

    }

}
