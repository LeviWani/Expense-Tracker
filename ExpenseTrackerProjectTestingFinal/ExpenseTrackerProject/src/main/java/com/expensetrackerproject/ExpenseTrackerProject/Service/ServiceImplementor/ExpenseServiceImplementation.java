package com.expensetrackerproject.ExpenseTrackerProject.Service.ServiceImplementor;

import com.expensetrackerproject.ExpenseTrackerProject.Dto.ExpenseDto;
import com.expensetrackerproject.ExpenseTrackerProject.Entities.Expense;
import com.expensetrackerproject.ExpenseTrackerProject.Entities.User;
import com.expensetrackerproject.ExpenseTrackerProject.Mapper.ExpenseMapper;
import com.expensetrackerproject.ExpenseTrackerProject.Mapper.UserMapper;
import com.expensetrackerproject.ExpenseTrackerProject.Repository.ExpenseRepo;
import com.expensetrackerproject.ExpenseTrackerProject.Repository.UserRepo;
import com.expensetrackerproject.ExpenseTrackerProject.Service.ServiceInterface.ExpenseServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

public class ExpenseServiceImplementation implements ExpenseServiceInterface {
    @Autowired
    private ExpenseMapper expenseMapper;
    @Autowired
    private ExpenseRepo expenseRepo;

    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        Expense expense = expenseMapper.expenseDtoToExpense(expenseDto);
        Expense savedExpense = expenseRepo.save(expense);
        return  expenseMapper.expenseToExpenseDto(savedExpense);
    }

    @Override
    public ExpenseDto updateExpense(ExpenseDto expenseDto, Long id) {

Expense expense = expenseRepo.findById(id).orElseThrow(
        ()-> new RuntimeException("user not found")
);
expense.setExpenseName(expenseDto .getExpenseName());
    expense.setExpenseAmount(expenseDto.getExpenseAmount());
    //expense.setCategory(expenseDto.getCategory());
    expense.setDate(expenseDto.getDate());

    Expense updatedExpense = expenseRepo.save(expense);
    return expenseMapper.expenseToExpenseDto(updatedExpense);
        }

    @Override
    public ExpenseDto deleteExpense( Long id) {
        Expense expense = expenseRepo.findById(id).orElseThrow(
                ()-> new ResourceAccessException("user with such an id wasnt found")
        );
    expenseRepo.delete(expense);
    return expenseMapper.expenseToExpenseDto(expense);
    }


    @Override
    public List<ExpenseDto> getAllExpsenses() {
    List<Expense> expenses = expenseRepo.findAll();
    return expenses.stream().map((temp)->expenseMapper.expenseToExpenseDto(temp)).toList();

    }

    @Override
    public List<ExpenseDto> getAllExpenseById(Long id) {
        List<Expense> expenses = expenseRepo.findByUser_userid(id);
        return expenses.stream().map((temp)->expenseMapper.expenseToExpenseDto(temp)).toList();
    }

}

