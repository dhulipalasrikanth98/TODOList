package com.example.todo.TODO.List.controller;

import com.example.todo.TODO.List.model.TodoApp;
import com.example.todo.TODO.List.repo.TodoRepo;
import com.example.todo.TODO.List.service.TodoAppService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/todo")
public class TodoAppController {
    @Autowired
    TodoAppService todoAppService;

    @GetMapping("getAll")
    public ResponseEntity<?> getAllTasks() {
        return new ResponseEntity<>(todoAppService.findAllUserWithTasks(), HttpStatus.OK);
    }
    @GetMapping("/addtask")
    public ResponseEntity<?> addTask(@RequestBody TodoApp todoApp) {
//        if(todoAppService.findByEmailId(todoApp.getEmailId()){
//            todoAppService.saveTask(todoApp.getTasks());
//        }
//        else{
//            todoAppService.saveUserAndAddTask(todoApp);
//        }
      return new ResponseEntity<>(null,HttpStatus.OK);
    }

}
