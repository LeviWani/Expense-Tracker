package com.expensetrackerproject.ExpenseTrackerProject.Dto;

import com.expensetrackerproject.ExpenseTrackerProject.Entities.Category;
import com.expensetrackerproject.ExpenseTrackerProject.Entities.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class ExpenseDto {


    private Long expenseid;

    private float expenseAmount;
    private String expenseName;

    private String category;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "useridid", referencedColumnName = "userid")
    private User user;



}
