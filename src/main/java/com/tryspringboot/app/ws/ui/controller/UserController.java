package com.tryspringboot.app.ws.ui.controller;


import com.tryspringboot.app.ws.service.UserService;
import com.tryspringboot.app.ws.shared.dto.UserDto;
import com.tryspringboot.app.ws.ui.model.request.UserDetailsRequestModel;
import com.tryspringboot.app.ws.ui.model.response.UserRest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser()
    {
        return "get user was called";
    }
    
    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails)
    {
        UserRest returnedValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnedValue);


        return returnedValue; 
    }

    @PutMapping
    public String updateUser()
    {
        return "update user called";
    }

    @DeleteMapping
    public String deleteUser()
    {
        return "delete user called";
    }

    
}
