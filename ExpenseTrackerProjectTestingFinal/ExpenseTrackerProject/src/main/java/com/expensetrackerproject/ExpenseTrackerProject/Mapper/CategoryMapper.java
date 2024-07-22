package com.expensetrackerproject.ExpenseTrackerProject.Mapper;

import com.expensetrackerproject.ExpenseTrackerProject.Dto.CategoryDto;
import com.expensetrackerproject.ExpenseTrackerProject.Dto.ExpenseDto;
import com.expensetrackerproject.ExpenseTrackerProject.Entities.Category;
import com.expensetrackerproject.ExpenseTrackerProject.Entities.Expense;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Category categoryDtoToCategory(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }

    public CategoryDto categoryToCategoryDto(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }


}

