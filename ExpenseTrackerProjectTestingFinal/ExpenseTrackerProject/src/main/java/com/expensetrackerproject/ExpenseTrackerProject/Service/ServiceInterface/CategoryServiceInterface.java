package com.expensetrackerproject.ExpenseTrackerProject.Service.ServiceInterface;

import com.expensetrackerproject.ExpenseTrackerProject.Dto.CategoryDto;
import com.expensetrackerproject.ExpenseTrackerProject.Dto.ExpenseDto;

import java.util.List;

public interface CategoryServiceInterface {
    CategoryDto createCategory(CategoryDto categoryDto);
    List<CategoryDto> getAllCategories();
    CategoryDto deleteCategory( Long id);
    CategoryDto updateCategory(CategoryDto categoryDto, Long id);
}
