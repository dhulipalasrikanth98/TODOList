package com.example.todo.TODO.List.exception;

import org.springframework.stereotype.Component;


public class InvalidEmailException extends RuntimeException{

    public InvalidEmailException(String exceptionMessage){
        super(exceptionMessage);
    }
}
