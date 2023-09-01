package com.example.todo.TODO.List.repo;

import com.example.todo.TODO.List.model.TodoApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<TodoApp, Long> {
    public TodoApp findByEmailId(String emailId);
}
