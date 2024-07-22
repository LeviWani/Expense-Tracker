package com.expensetrackerproject.ExpenseTrackerProject.Dto;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter

@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CategoryDto {

    private Long categoryid;

    private String categoryname;

    private float categoryamount;




}
