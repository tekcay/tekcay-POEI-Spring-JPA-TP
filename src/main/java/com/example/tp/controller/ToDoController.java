package com.example.tp.controller;

import com.example.tp.entity.ToDo;
import com.example.tp.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todo")
@ResponseBody
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @PostMapping("")
    public ToDo addToDo(@RequestBody ToDo toDo) {
        if(toDoService.add(toDo)) return null;
        return toDo;
    }

    @PostMapping("/modify/{id}")
    public ToDo modifyById(@PathVariable("id") int id, @RequestBody ToDo toDo) {
        ToDo toDoToModify = toDoService.findById(id);
        if (toDoToModify == null) return null;

        toDoToModify.setDate(toDo.getDate());
        toDoToModify.setDescription(toDo.getDescription());
        toDoToModify.setDone(toDo.isDone());
        toDoToModify.setTitle(toDo.getTitle());

        if (toDoService.modify(toDoToModify)) return toDoToModify;
        return null;
    }

    @PostMapping("/modify-id-done/{id}")
    public ToDo modifyIsDoneById(@PathVariable("id") int id, @RequestBody ToDo toDo) {
        ToDo toDoToModify = toDoService.findById(id);
        if (toDoToModify == null) return null;

        toDoToModify.setDone(toDo.isDone());

        if (toDoService.modify(toDoToModify)) return toDoToModify;
        return null;
    }

    @PostMapping("get-all/{isDone}")
    public List<ToDo> getAllByIsDone(@PathVariable("isDone") String isDone) {
        if (isDone.equals("true")) return toDoService.getToDos(true);
        if (isDone.equals("false")) return toDoService.getToDos(false);
        return null;
    }

}
