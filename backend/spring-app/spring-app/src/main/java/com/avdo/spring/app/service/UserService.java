package com.avdo.spring.app.service;

import com.avdo.spring.app.controller.dto.CreateUserDto;
import com.avdo.spring.app.controller.dto.LoginUserRequest;
import com.avdo.spring.app.entity.UserEntity;

public interface UserService {

    UserEntity createUser(CreateUserDto createUserDto);
    UserEntity authenticate(LoginUserRequest loginUserRequest);
}
