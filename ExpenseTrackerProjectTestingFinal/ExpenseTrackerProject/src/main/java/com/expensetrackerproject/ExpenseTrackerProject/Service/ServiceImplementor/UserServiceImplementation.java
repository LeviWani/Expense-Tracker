package com.expensetrackerproject.ExpenseTrackerProject.Service.ServiceImplementor;

import com.expensetrackerproject.ExpenseTrackerProject.Dto.UserDto;
import com.expensetrackerproject.ExpenseTrackerProject.Entities.User;
import com.expensetrackerproject.ExpenseTrackerProject.Mapper.UserMapper;
import com.expensetrackerproject.ExpenseTrackerProject.Repository.UserRepo;
import com.expensetrackerproject.ExpenseTrackerProject.Service.ServiceInterface.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImplementation implements UserServiceInterface {

    @Autowired
private UserMapper userMapper;
    @Autowired
private  UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.UserDtoTouser(userDto);
        User savedUser = userRepo.save(user);
        return userMapper.userToUserDto(savedUser);
    }
    @Override
    public UserDto updatePassword(UserDto userDto, Long id) {
      User user = userRepo.findById(id).orElseThrow(
              ()-> new RuntimeException("user not found")
              );
        user.setPassword(userDto.getPassword());
        User updtatedUser =userRepo.save(user);
        return  userMapper.userToUserDto(updtatedUser);
    }
    @Override
    public UserDto getUserById(Long id) {
        User user = userRepo.findById(id).orElseThrow(
                ()-> new RuntimeException("user not found")
        );
        return userMapper.userToUserDto(user);

    }
    @Override
    public String getUserName(Long id) {
        User user = userRepo.findById(id).orElseThrow(
                ()-> new RuntimeException("user not found")
        );
        return  user.getName();
    }

    @Override

        public UserDto login(String name, String password) {
            User user = userRepo.findByName(name);
        return  userMapper.userToUserDto(user);
        }




}
