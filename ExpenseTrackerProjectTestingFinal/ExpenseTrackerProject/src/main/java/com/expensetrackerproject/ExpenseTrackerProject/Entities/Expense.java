package com.expensetrackerproject.ExpenseTrackerProject.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "expense") // Specify table name
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "expenseid")

    private Long expenseid;
    private String expenseName;

    private float expenseAmount;
    private String category;


    private Date date;
    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private User user;




}
