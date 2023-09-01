package com.example.todo.TODO.List.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

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
    long id;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    TodoApp todoApp;

    @Column(name = "task_name")
    String taskName;
}
