package com.expensetrackerproject.ExpenseTrackerProject.Configuration;

import com.expensetrackerproject.ExpenseTrackerProject.Mapper.CategoryMapper;
import com.expensetrackerproject.ExpenseTrackerProject.Mapper.ExpenseMapper;
import com.expensetrackerproject.ExpenseTrackerProject.Mapper.UserMapper;
import com.expensetrackerproject.ExpenseTrackerProject.Service.ServiceImplementor.CategoryServiceImplementation;
import com.expensetrackerproject.ExpenseTrackerProject.Service.ServiceImplementor.ExpenseServiceImplementation;
import com.expensetrackerproject.ExpenseTrackerProject.Service.ServiceImplementor.UserServiceImplementation;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan

public class AppConfig {
@Bean
public ModelMapper modelMapper(){
    return new ModelMapper();
}

//user

@Bean
    public UserServiceImplementation userServiceImplementation(){
    return new UserServiceImplementation();
}

@Bean
    public UserMapper userMapper(){
    return  new UserMapper();
}

//expense

@Bean
    public ExpenseServiceImplementation expenseServiceImplementation(){
    return  new ExpenseServiceImplementation();
}

@Bean
    public ExpenseMapper expenseMapper(){
    return  new ExpenseMapper();

}
///

    @Bean
    public CategoryMapper categoryMapper(){
    return  new CategoryMapper();
    }
    @Bean
   public CategoryServiceImplementation categoryServiceImplementation(){
    return  new CategoryServiceImplementation();
    }



}
