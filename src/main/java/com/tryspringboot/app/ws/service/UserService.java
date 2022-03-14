package com.tryspringboot.app.ws.service;

import com.tryspringboot.app.ws.shared.dto.UserDto;

public interface UserService {
    
   UserDto createUser(UserDto user);
}
