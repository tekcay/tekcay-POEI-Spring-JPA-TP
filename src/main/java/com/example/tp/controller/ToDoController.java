package com.example.tp.controller;

import com.example.tp.entity.ToDo;
import com.example.tp.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("todo")
@ResponseBody
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @PostMapping("")
    public ToDo addToDo(@RequestBody ToDo toDo) {
        return toDoService.create(toDo) ? toDo : null;
    }

}
