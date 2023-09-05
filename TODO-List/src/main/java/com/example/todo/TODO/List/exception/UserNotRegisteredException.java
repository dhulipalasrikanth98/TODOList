package com.example.todo.TODO.List.exception;

import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UserNotRegisteredException extends RuntimeException{

    public UserNotRegisteredException(String s){
        super(s);
    }


}
