package com.expensetrackerproject.ExpenseTrackerProject.Dto;

import com.expensetrackerproject.ExpenseTrackerProject.Entities.Expense;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;



@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class UserDto {

    private Long userid;

    private String email;
    private String name;
    private String password;
    private float amount;



}

