package com.example.todo.TODO.List.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "todo_app")
public class TodoApp{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private long  id;

    @Column(name="email_id")
    @NotEmpty
    private String emailId;


    @Column(name = "task")
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "todoApp",orphanRemoval = true)
    private List<Task> tasks;


    @Override
    public String toString(){
       StringBuilder res = new StringBuilder();
       List<String> tasks = new ArrayList<>();
       for(Task t:this.tasks){
           res.append("[");
           res.append(t.getTaskId());
           res.append(" "+t.getTaskName());
           res.append("]");
       }
       return res.toString();
    }

}
