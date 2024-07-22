package com.expensetrackerproject.ExpenseTrackerProject.Controller;


import com.expensetrackerproject.ExpenseTrackerProject.Dto.ExpenseDto;
import com.expensetrackerproject.ExpenseTrackerProject.Dto.UserDto;
import com.expensetrackerproject.ExpenseTrackerProject.Entities.Expense;
import com.expensetrackerproject.ExpenseTrackerProject.Service.ServiceImplementor.ExpenseServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private  ExpenseServiceImplementation expenseServiceImplementation;
    @PostMapping("/create-expense")
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto){
        ExpenseDto expenseDto1 = expenseServiceImplementation.createExpense(expenseDto);
        return  new ResponseEntity<>(expenseDto1, HttpStatus.CREATED);

    }
    @PutMapping("/update-expense/{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@RequestBody ExpenseDto expenseDto, @PathVariable Long id){
        ExpenseDto expenseDto1 = expenseServiceImplementation.updateExpense(expenseDto, id);
        return ResponseEntity.ok(expenseDto1);
    }
    @GetMapping("/get-expenses")
    public List<ExpenseDto> getAllExpenses(){
        return expenseServiceImplementation.getAllExpsenses();
    }

    @DeleteMapping("/delete-expense/{id}")
    public ResponseEntity<String> deleteExpenses(@PathVariable Long id){
        expenseServiceImplementation.deleteExpense(id);
        return ResponseEntity.ok("deleted");
    }
    @GetMapping("/expense-by-user-id/{userid}")
    public ResponseEntity<List<ExpenseDto>> getExpenseByUserId(@PathVariable Long userid){
        List<ExpenseDto> expenses = expenseServiceImplementation.getAllExpenseById(userid);
        return ResponseEntity.ok(expenses);
    }

}
