package com.expensetrackerproject.ExpenseTrackerProject.Repository;

import com.expensetrackerproject.ExpenseTrackerProject.Entities.Expense;
import com.expensetrackerproject.ExpenseTrackerProject.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepo extends JpaRepository<Expense, Long> {
    List<Expense> findByUser_userid(Long id);

}
