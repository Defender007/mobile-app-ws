package com.tryspringboot.app.ws.service;

import com.tryspringboot.app.ws.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    
   UserDto createUser(UserDto user);
}
