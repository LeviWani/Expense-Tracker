package com.expensetrackerproject.ExpenseTrackerProject.Controller;

import com.expensetrackerproject.ExpenseTrackerProject.Dto.UserDto;
import com.expensetrackerproject.ExpenseTrackerProject.Entities.User;
import com.expensetrackerproject.ExpenseTrackerProject.Service.ServiceImplementor.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImplementation userServiceImplementation;

    @PostMapping("create-user")
    public ResponseEntity<UserDto>  createUser(@RequestBody UserDto userDto){
        UserDto userDto1 = userServiceImplementation.createUser(userDto);
        return  new ResponseEntity<>(userDto1, HttpStatus.CREATED);
    }

    @PutMapping("update-user/{id}")
    public ResponseEntity<UserDto> updatePassword(@RequestBody UserDto userDto,  @PathVariable Long id){
        UserDto userDto1 = userServiceImplementation.updatePassword(userDto, id);
        return ResponseEntity.ok(userDto1);
    }

    @GetMapping("get-user/{id}")
    public  ResponseEntity<UserDto > getUserById(@PathVariable Long id){
        UserDto userDto = userServiceImplementation.getUserById(id);
        return ResponseEntity.ok(userDto);
    }
    @GetMapping("get-user-name/{id}")
    public  String getUserName(@PathVariable Long id){
        UserDto userDto = userServiceImplementation.getUserById(id);
        return userDto.getName();
    }

    @PostMapping("/login")
    public UserDto login(@RequestBody User loginUser) {
        String name = loginUser.getName();
        String password = loginUser.getPassword();
        UserDto user = userServiceImplementation.login(name, password);
        return user;
    }







}
