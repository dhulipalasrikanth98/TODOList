package com.example.todo.TODO.List.service;

import com.example.todo.TODO.List.model.TodoApp;
import com.example.todo.TODO.List.repo.TodoRepo;
import com.sun.tools.javac.comp.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoAppService {
    @Autowired
    TodoRepo todoRepo;
    public boolean findByEmailId(String emailId){
        return todoRepo.findByEmailId(emailId) == null;
    }
    public List<TodoApp> findAllUserWithTasks(){
        return todoRepo.findAll();
    }
}
