package com.expensetrackerproject.ExpenseTrackerProject.Service.ServiceImplementor;

import com.expensetrackerproject.ExpenseTrackerProject.Dto.CategoryDto;
import com.expensetrackerproject.ExpenseTrackerProject.Entities.Category;
import com.expensetrackerproject.ExpenseTrackerProject.Mapper.CategoryMapper;
import com.expensetrackerproject.ExpenseTrackerProject.Repository.CategoryRepo;
import com.expensetrackerproject.ExpenseTrackerProject.Service.ServiceInterface.CategoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;

public class CategoryServiceImplementation implements CategoryServiceInterface {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private CategoryRepo categoryRepo;

@Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        // Check if a category with the same name exists
        Optional<Category> existingCategory = categoryRepo.findByCategoryname(categoryDto.getCategoryname());

        if (existingCategory.isPresent()) {
            // If the category already exists, return the existing category as DTO
            return categoryMapper.categoryToCategoryDto(existingCategory.get());
        } else {
            // If the category does not exist, create and save a new one
            Category category = categoryMapper.categoryDtoToCategory(categoryDto);
            Category savedCategory = categoryRepo.save(category);
            return categoryMapper.categoryToCategoryDto(savedCategory);
        }
    }


    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepo.findAll();
        return categories.stream().map((temp)->categoryMapper.categoryToCategoryDto(temp)).toList();

    }

    @Override
    public CategoryDto deleteCategory(Long id) {

            Category category = categoryRepo.findById(id).orElseThrow(
                    ()-> new ResourceAccessException("user with such an id wasnt found")
            );
            categoryRepo.delete(category);
            return categoryMapper.categoryToCategoryDto(category);
        }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long id) {
        Category category = categoryRepo.findById(id).orElseThrow(
                ()-> new RuntimeException("user not found")
        );
        category.setCategoryname(categoryDto.getCategoryname());
        category.setCategoryamount(categoryDto.getCategoryamount());
        Category updtatedCategory =categoryRepo.save(category);
        return  categoryMapper.categoryToCategoryDto(updtatedCategory);

    }

}
