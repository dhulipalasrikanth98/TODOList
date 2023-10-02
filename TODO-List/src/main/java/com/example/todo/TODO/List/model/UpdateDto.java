package com.example.todo.TODO.List.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@ToString

public class UpdateDto {
    @NotEmpty
    private String emailId;
    private long taskId;
    private String taskName;


}
