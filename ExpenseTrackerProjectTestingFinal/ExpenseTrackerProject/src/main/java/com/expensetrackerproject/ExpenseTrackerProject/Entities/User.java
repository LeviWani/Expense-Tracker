package com.expensetrackerproject.ExpenseTrackerProject.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "user") // Specify table name
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private Long userid;

    private String email;
    private String name;
    private String password;
    private float amount;





}
