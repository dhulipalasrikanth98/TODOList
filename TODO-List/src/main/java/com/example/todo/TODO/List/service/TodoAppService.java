package com.example.todo.TODO.List.service;

import com.example.todo.TODO.List.exception.InvalidEmailException;
import com.example.todo.TODO.List.exception.InvalidTasks;
import com.example.todo.TODO.List.exception.UserNotRegisteredException;
import com.example.todo.TODO.List.model.*;
import com.example.todo.TODO.List.repo.TaskRepo;
import com.example.todo.TODO.List.repo.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TodoAppService {
    @Autowired
    TodoRepo todoRepo;

    @Autowired
    TaskRepo taskRepo;

    public TodoApp findByEmailId(String emailId){
        return todoRepo.findByEmailId(emailId);
    }
    public List<TodoApp> findAllUserWithTasks(int pageNo,int pageSize){
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return todoRepo.findAll(pageable).getContent();
    }

    public TodoApp findUserByEmailAndAddTask(TodoApp todoApp) {
        TodoApp user = findByEmailId(todoApp.getEmailId());
        if(user == null){
           TodoApp userDetails = todoRepo.save(todoApp);
            for(Task t : todoApp.getTasks()){
                t.setTodoApp(userDetails);
                taskRepo.save(t);
            }
            user = userDetails;
        }
        else{
            for(Task t : todoApp.getTasks()){
                t.setTodoApp(user);
                taskRepo.save(t);
            }

        }
        return user;
    }

    public TodoApp findUserByEmailAndUpdateTask(UpdateDto updateDto) {
        if(updateDto.getEmailId().isEmpty()){
            throw new InvalidEmailException("There is no email id found"+"please enter and try to update");
        }

        else{
           TodoApp todoApp = todoRepo.findByEmailId(updateDto.getEmailId());

            if(todoApp != null){
                List<Task> tasks  = todoApp.getTasks();
                for(int i = 0; i < tasks.size(); i++){
                    if(tasks.get(i).getTaskId() == updateDto.getTaskId()){
                        tasks.get(i).setTaskName(updateDto.getTaskName());
                        todoApp.setTasks(tasks);
                        todoRepo.save(todoApp);
                        return todoApp;
                    }
                }
                throw new InvalidTasks("No task found with id :" + updateDto.getTaskId());
            }
            else{
                throw new InvalidEmailException("No user found with this email id"+updateDto.getEmailId());
            }
        }
    }

    public String findUserByEmailAndDeleteTask(DeleteDto deleteDto) {
        TodoApp todoApp = todoRepo.findByEmailId(deleteDto.getEmailId());

        if(todoApp != null){
            List<Task> tasks  = todoApp.getTasks();
            int index = -1;
            for(int i = 0; i < tasks.size(); i++){
                if(tasks.get(i).getTaskId() == deleteDto.getTaskId()){
                    //taskRepo.delete(tasks.get(i));
                    index = i;
                    break;
                }
            }
            if(index != -1){
                todoApp.getTasks().remove(tasks.get(index));
                todoRepo.save(todoApp);
                return "task deleted successfully";
            }
                return "no task found";
        }
        else{
            return "no user found with that email";
        }
    }

    public List<?> findAllTasksOfSpecificUser(String emailId,int pageNo, int pageSize) {

        if(pageNo < 0){
            throw new IllegalArgumentException("enter the pageNo >= 0");
        }
        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by("i.date","i.taskName"));
        Page<List<Task>> list = todoRepo.findByEmailIdTasks(emailId,pageable);
        return list.getContent();

    }
}
