package com.example.todo.TODO.List.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private long taskId;

    @Column(name = "date")
    @Temporal(value = TemporalType.DATE)
    private Date date = new Date();

    @Column(name = "task_name")
    private String taskName;

    @ManyToOne
    @JoinColumn(name="todo_id")
    @JsonBackReference
    private TodoApp todoApp;
}
