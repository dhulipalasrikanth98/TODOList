package com.example.todo.TODO.List.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DeleteDto {
    private String emailId;
    private long taskId;
}
