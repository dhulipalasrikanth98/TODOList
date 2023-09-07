package com.example.todo.TODO.List.repo;


import com.example.todo.TODO.List.model.Task;
import com.example.todo.TODO.List.model.TaskDto;
import com.example.todo.TODO.List.model.TodoApp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepo extends JpaRepository<TodoApp, Long> {
    public TodoApp findByEmailId(String emailId);
    @Query(value = "select i from TodoApp t left join t.tasks i where t.emailId = :emailId",
           countQuery = "select count(i) from TodoApp t left join t.tasks i where t.emailId = :emailId")
     Page<List<Task>> findByEmailIdTasks(@Param("emailId") String emailId,Pageable pageable);

}
