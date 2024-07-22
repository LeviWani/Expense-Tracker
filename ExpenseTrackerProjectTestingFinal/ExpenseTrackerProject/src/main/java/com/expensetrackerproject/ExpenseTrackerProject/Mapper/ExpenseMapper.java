package com.expensetrackerproject.ExpenseTrackerProject.Mapper;

import com.expensetrackerproject.ExpenseTrackerProject.Dto.ExpenseDto;
import com.expensetrackerproject.ExpenseTrackerProject.Dto.UserDto;
import com.expensetrackerproject.ExpenseTrackerProject.Entities.Expense;
import com.expensetrackerproject.ExpenseTrackerProject.Entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ExpenseMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Expense expenseDtoToExpense(ExpenseDto expenseDto){
        return  modelMapper.map(expenseDto, Expense.class);
    }
    public ExpenseDto expenseToExpenseDto(Expense expense){
        return  modelMapper.map(expense, ExpenseDto.class);

    }
}

