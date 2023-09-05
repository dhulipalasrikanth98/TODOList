package com.example.todo.TODO.List.controller;

import com.example.todo.TODO.List.exception.UserNotRegisteredException;
import com.example.todo.TODO.List.model.TodoApp;
import com.example.todo.TODO.List.model.UpdateDto;
import com.example.todo.TODO.List.repo.TodoRepo;
import com.example.todo.TODO.List.service.TodoAppService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/todo")
public class TodoAppController {
    @Autowired
    TodoAppService todoAppService;

    @GetMapping("getAll")
    public ResponseEntity<?> getAllTasks() {
        return new ResponseEntity<>(todoAppService.findAllUserWithTasks(), HttpStatus.OK);
    }
    @PostMapping("/addtask")
    public ResponseEntity<?> addTask(@RequestBody TodoApp todoApp) {
        try {
            todoAppService.findUserByEmailAndAddTask(todoApp);
        }
        catch(UserNotRegisteredException userNotRegisteredException){
            return new ResponseEntity<>("no user registered with this user + "+todoApp.getId(),HttpStatus.BAD_GATEWAY);
        }

      return new ResponseEntity<>(todoApp,HttpStatus.OK);
    }
    @PutMapping("/updatetask")
    public ResponseEntity<?> updateTask(@RequestBody UpdateDto updateDto) {
        try {
            todoAppService.findUserByEmailAndUpdateTask(updateDto);
        }
        catch(UserNotRegisteredException userNotRegisteredException){
            return new ResponseEntity<>("no user registered with this user + "+updateDto.getEmailId(),HttpStatus.BAD_GATEWAY);
        }

        return new ResponseEntity<>(updateDto.getTask(),HttpStatus.OK);
    }

}
