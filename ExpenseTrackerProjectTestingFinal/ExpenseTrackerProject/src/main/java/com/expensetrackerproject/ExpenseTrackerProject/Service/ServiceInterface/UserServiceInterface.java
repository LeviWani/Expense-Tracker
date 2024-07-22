package com.expensetrackerproject.ExpenseTrackerProject.Service.ServiceInterface;

import com.expensetrackerproject.ExpenseTrackerProject.Dto.UserDto;
import com.expensetrackerproject.ExpenseTrackerProject.Entities.User;

public interface UserServiceInterface {
    UserDto createUser(UserDto userDto);
    UserDto updatePassword(UserDto userDto, Long id);
    UserDto getUserById(Long id);
    String getUserName(Long id);
    UserDto login(String name, String password);
}
