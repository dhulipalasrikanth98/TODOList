package com.example.todo.TODO.List.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DeleteDto {
    @NotEmpty
    private String emailId;
    private long taskId;
}
