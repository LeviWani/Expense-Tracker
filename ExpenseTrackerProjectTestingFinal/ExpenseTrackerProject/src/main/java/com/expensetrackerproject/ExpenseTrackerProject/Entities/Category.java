package com.expensetrackerproject.ExpenseTrackerProject.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categoryid")
    private Long categoryid;

    private String categoryname;
    private float categoryamount;

    public Category() {
    }

    public Category(Long categoryid, String categoryname, float categoryamount) {
        this.categoryid = categoryid;
        this.categoryname = categoryname;
        this.categoryamount = categoryamount;
    }
}
