package com.example.todo.TODO.List.service;

import com.example.todo.TODO.List.exception.InvalidEmailException;
import com.example.todo.TODO.List.exception.InvalidTasks;
import com.example.todo.TODO.List.exception.UserNotRegisteredException;
import com.example.todo.TODO.List.model.TodoApp;
import com.example.todo.TODO.List.model.UpdateDto;
import com.example.todo.TODO.List.repo.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoAppService {
    @Autowired
    TodoRepo todoRepo;
    public TodoApp findByEmailId(String emailId){
        return todoRepo.findByEmailId(emailId);
    }
    public List<TodoApp> findAllUserWithTasks(){
        return todoRepo.findAll();
    }

    public void findUserByEmailAndAddTask(TodoApp todoApp) {
        if(findByEmailId(todoApp.getEmailId()) == null){

            todoRepo.save(todoApp);
        }
        else{
            throw new UserNotRegisteredException("user with this id +"+todoApp.getId()+"is not registered");
        }
    }

    public void findUserByEmailAndUpdateTask(UpdateDto updateDto) {
        if(updateDto.getEmailId().isEmpty()){
            throw new InvalidEmailException("There is no email id found"+"please enter and try to update");
        }
        else if(updateDto.getTask().size() == 0){
            throw new InvalidTasks("there are no task please add some !!!");
        }
        else{
            TodoApp todoApp = findByEmailId(updateDto.getEmailId());
            if(todoApp != null){
                todoApp.getTasks().addAll(updateDto.getTask());
                todoRepo.save(todoApp);

            }
            else{
                throw new InvalidEmailException("No user found with this email id"+updateDto.getEmailId());
            }
        }
    }
}
