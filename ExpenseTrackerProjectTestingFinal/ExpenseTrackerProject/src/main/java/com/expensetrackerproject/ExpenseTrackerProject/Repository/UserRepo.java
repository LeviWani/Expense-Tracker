package com.expensetrackerproject.ExpenseTrackerProject.Repository;

import com.expensetrackerproject.ExpenseTrackerProject.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long>{
    User findByName(String name);
}
