package com.example.todo.TODO.List.controller;

import com.example.todo.TODO.List.model.DeleteDto;
import com.example.todo.TODO.List.model.TodoApp;
import com.example.todo.TODO.List.model.UpdateDto;
import com.example.todo.TODO.List.service.TodoAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/todo")
public class TodoAppController {
    @Autowired
    TodoAppService todoAppService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(@RequestParam(value = "pageNo",defaultValue = "10") int pageNo,
                                         @RequestParam(value="pageSize",defaultValue="1") int pageSize) {
        return new ResponseEntity<>(todoAppService.findAllUserWithTasks(pageNo,pageSize), HttpStatus.OK);
    }
    @GetMapping("/getAll/task/")
    public ResponseEntity<?> getAllTasks(@RequestParam(value="emailId") String emailId,
                                         @RequestParam(value = "pageNo",defaultValue = "10") int pageNo,
                                         @RequestParam(value="pageSize",defaultValue="1") int pageSize) {
        return new ResponseEntity<>(todoAppService.findAllTasksOfSpecificUser(emailId,pageNo,pageSize), HttpStatus.OK);
    }
    @PostMapping("/addtask")
    public ResponseEntity<?> addTask(@RequestBody TodoApp todoApp) {
      return new ResponseEntity<>( todoAppService.findUserByEmailAndAddTask(todoApp),HttpStatus.OK);
    }
    @PutMapping("/updatetask")
    public ResponseEntity<?> updateTask(@RequestBody UpdateDto updateDto) {
        return new ResponseEntity<>( todoAppService.findUserByEmailAndUpdateTask(updateDto),HttpStatus.OK);
    }
    @DeleteMapping("/deleteTask")
    public ResponseEntity<?> deleteMapping(@RequestBody DeleteDto deleteDto) {
        return new ResponseEntity<>(todoAppService.findUserByEmailAndDeleteTask(deleteDto),HttpStatus.OK);
    }

}
