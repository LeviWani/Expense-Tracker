package com.expensetrackerproject.ExpenseTrackerProject.Controller;


import com.expensetrackerproject.ExpenseTrackerProject.Dto.CategoryDto;
import com.expensetrackerproject.ExpenseTrackerProject.Dto.ExpenseDto;
import com.expensetrackerproject.ExpenseTrackerProject.Dto.UserDto;
import com.expensetrackerproject.ExpenseTrackerProject.Service.ServiceImplementor.CategoryServiceImplementation;
import com.expensetrackerproject.ExpenseTrackerProject.Service.ServiceImplementor.ExpenseServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryServiceImplementation categoryServiceImplementation;

    @PostMapping("/create-category")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto categoryDto1 = categoryServiceImplementation.createCategory(categoryDto);
        return  new ResponseEntity<>(categoryDto1, HttpStatus.CREATED);
    }

    @GetMapping("/get-categories")
    public List<CategoryDto> getAllCategories() {
        return categoryServiceImplementation.getAllCategories();
    }

    @DeleteMapping("/delete-category/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        categoryServiceImplementation.deleteCategory(id);
        return ResponseEntity.ok("deleted category");
    }

    @PutMapping("/update-category/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable Long id){
        CategoryDto category = categoryServiceImplementation.updateCategory(categoryDto, id);
        return ResponseEntity.ok(category);
    }


}
