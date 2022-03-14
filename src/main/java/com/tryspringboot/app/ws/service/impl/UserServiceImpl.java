package com.tryspringboot.app.ws.service.impl;

import com.tryspringboot.app.ws.UserRepository;
import com.tryspringboot.app.ws.io.entity.UserEntity;
import com.tryspringboot.app.ws.service.UserService;
import com.tryspringboot.app.ws.shared.Utils;
import com.tryspringboot.app.ws.shared.dto.UserDto;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Override
    public UserDto createUser(UserDto user) {
        

        if(userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Record already exists");


        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);


        
        userEntity.setEncryptedPassword("test");
        userEntity.setUserId("testUserId");

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnedValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnedValue);

        return returnedValue;
    }

}
