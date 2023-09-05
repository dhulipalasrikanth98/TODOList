package com.example.todo.TODO.List.exception;

import org.springframework.stereotype.Component;


public class InvalidTasks extends RuntimeException{
    public InvalidTasks(String message){
        super(message);
    }

}
