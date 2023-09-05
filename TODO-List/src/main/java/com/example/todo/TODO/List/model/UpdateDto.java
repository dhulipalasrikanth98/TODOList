package com.example.todo.TODO.List.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString

public class UpdateDto {
    String emailId;
    List<Task> task;

}
