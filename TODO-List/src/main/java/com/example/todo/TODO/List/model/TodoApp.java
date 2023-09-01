package com.example.todo.TODO.List.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "todo_app")
public class TodoApp{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private long  id;

    @Column
    private String emailId;

    @Column(name = "date")
    private Date date;

    @Column(name = "task")
    @OneToMany(mappedBy="todoApp",cascade = CascadeType.DETACH)
    private List<Task> tasks;


}
