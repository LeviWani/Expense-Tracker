package com.expensetrackerproject.ExpenseTrackerProject.Mapper;

import com.expensetrackerproject.ExpenseTrackerProject.Dto.UserDto;
import com.expensetrackerproject.ExpenseTrackerProject.Entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapper {
    @Autowired
    private ModelMapper modelMapper;

    public User UserDtoTouser(UserDto userDto){
        return  modelMapper.map(userDto, User.class);
    }
    public UserDto userToUserDto(User user){
        return  modelMapper.map(user, UserDto.class);

    }

}
