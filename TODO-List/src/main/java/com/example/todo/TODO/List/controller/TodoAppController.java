package com.example.todo.TODO.List.controller;

import com.example.todo.TODO.List.repo.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/todo")
public class TodoAppController {
    @Autowired
    TodoRepo todoRepo;
    @GetMapping("getAll")
    public ResponseEntity<?> getAllTasks(){
        return new ResponseEntity<>(todoRepo.findAll(), HttpStatus.OK);
    }
}
