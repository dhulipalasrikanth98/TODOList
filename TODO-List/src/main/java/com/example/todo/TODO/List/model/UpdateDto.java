package com.example.todo.TODO.List.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString

public class UpdateDto {
    private String emailId;
    private long taskId;
    private String taskName;


}
