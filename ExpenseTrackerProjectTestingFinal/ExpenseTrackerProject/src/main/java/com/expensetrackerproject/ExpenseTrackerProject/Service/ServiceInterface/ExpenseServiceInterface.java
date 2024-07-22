package com.expensetrackerproject.ExpenseTrackerProject.Service.ServiceInterface;

import com.expensetrackerproject.ExpenseTrackerProject.Dto.ExpenseDto;

import java.util.List;

public interface ExpenseServiceInterface {

    ExpenseDto createExpense(ExpenseDto expenseDto);
    ExpenseDto updateExpense(ExpenseDto expenseDto, Long id);
    ExpenseDto deleteExpense( Long id);
    List<ExpenseDto> getAllExpsenses();
    List<ExpenseDto> getAllExpenseById(Long id);

}
