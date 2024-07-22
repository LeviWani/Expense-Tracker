package com.expensetrackerproject.ExpenseTrackerProject.Repository;

import com.expensetrackerproject.ExpenseTrackerProject.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    Optional<Category> findByCategoryname(String categoryname);
}
